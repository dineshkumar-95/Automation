package org.example.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class ConfigManager {

    private static final String CONFIG_FILE = "config.yml";

    // Shared read-only YAML configuration
    private static final Map<String, Object> config;
    private static final Map<String, Object> sites;

    // Each TestNG thread gets its own configuration
    private static final ThreadLocal<String> currentSite = new ThreadLocal<>();

    private static final ThreadLocal<Map<String, Object>> currentSiteConfig = new ThreadLocal<>();

    // Used locally; ignored if .env does not exist
    private static final Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();

    // Load YAML once when ConfigManager is first used
    static {
        config = loadYaml();
        sites = getSites();
    }

    /**
     * Load config.yml.
     */
    private static Map<String, Object> loadYaml() {

        try (InputStream inputStream = ConfigManager.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {

            if (inputStream == null) {
                throw new RuntimeException(
                        "Configuration file not found: " + CONFIG_FILE);
            }

            Map<String, Object> loadedConfig =
                    new Yaml().load(inputStream);

            if (loadedConfig == null) {
                throw new RuntimeException(
                        "Configuration file is empty: " + CONFIG_FILE);
            }

            return loadedConfig;

        } catch (Exception e) {
            throw new RuntimeException(
                    "Failed to load configuration: " + CONFIG_FILE, e);
        }
    }

    /**
     * Get sites from YAML.
     */
    @SuppressWarnings("unchecked")
    private static Map<String, Object> getSites() {

        Object sitesConfig = config.get("sites");

//        if (!(sitesConfig instanceof Map)) {
//            throw new RuntimeException("'sites' section not found in " + CONFIG_FILE);
//        }

        return (Map<String, Object>) sitesConfig;
    }

    /**
     * Set site for the current TestNG thread.
     *
     * Site MUST be provided from TestNG.
     */
    public static void setSite(String siteName) {

        if (siteName == null || siteName.isBlank()) {
            throw new IllegalArgumentException("siteName must be provided from TestNG XML");
        }

        if (siteName.equals("${siteName}")) {
            throw new IllegalArgumentException("siteName was not resolved by TestNG: " + siteName);
        }

        Object siteObject = sites.get(siteName);

        if (!(siteObject instanceof Map)) {
            throw new RuntimeException("Site not found in configuration: " + siteName);
        }

        @SuppressWarnings("unchecked")
        Map<String, Object> siteConfig = (Map<String, Object>) siteObject;

        /*
         * Create a separate copy for this thread.
         *
         * This is important for parallel execution.
         */
        Map<String, Object> threadConfig = new HashMap<>(siteConfig);
        currentSite.set(siteName);
        currentSiteConfig.set(threadConfig);

        // Override credentials from environment variables
        mergeCredentialsFromEnvironmentVariables();
    }

    /**
     * Override username, password and API key
     * from .env or CI environment variables.
     */
    private static void mergeCredentialsFromEnvironmentVariables() {
        String prefix = getCurrentSite().toUpperCase().replace("-", "_");
        overrideIfPresent("username", prefix + "_USERNAME");
        overrideIfPresent("password", prefix + "_PASSWORD");
        overrideIfPresent("api_key", prefix + "_API_KEY");
    }

    /**
     * Override configuration value if environment variable exists.
     */
    private static void overrideIfPresent(String configKey, String environmentVariable) {

        String value = getEnv(environmentVariable);

        if (value != null && !value.isBlank()) {
            currentSiteConfig.get().put(configKey, value);
        }
    }

    /**
     * Read from .env first.
     * If not found, read from system environment.
     */
    private static String getEnv(String name) {

        String value = dotenv.get(name);

        if (value != null && !value.isBlank()) {
            return value;
        }

        return System.getenv(name);
    }

    /**
     * Get configuration value for current thread.
     */
    private static String getValue(String key) {

        Map<String, Object> siteConfig = currentSiteConfig.get();
        if (siteConfig == null) {
            throw new IllegalStateException("Site configuration has not been initialized for the current thread. Call ConfigManager.setSite(siteName) first.");
        }

        Object value = siteConfig.get(key);
        if (value == null) {
            throw new RuntimeException(key + " not found for site: " + getCurrentSite());
        }
        return value.toString();
    }

    public static String getUsername() {
        return getValue("username");
    }

    public static String getPassword() {
        return getValue("password");
    }

    public static String getSiteUrl() {
        return getValue("site_url");
    }

    public static String getApiBaseUri() {
        return getValue("api_base_uri");
    }

    public static String getApiKey() {
        return getValue("api_key");
    }

    public static String getCurrentSite() {

        String site = currentSite.get();

        if (site == null) {
            throw new IllegalStateException("No site configured for the current thread.");
        }
        return site;
    }

    /**
     * Clear ThreadLocal values after the test class finishes.
     */
    public static void clear() {
        currentSite.remove();
        currentSiteConfig.remove();
    }
}