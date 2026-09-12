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

    // Each TestNG thread gets its own site configuration
    private static final ThreadLocal<Map<String, Object>> currentSiteConfig = new ThreadLocal<>();

    // Load .env if available
    private static final Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();

    // Load YAML once when ConfigManager is first used
    static {
        config = loadYaml();
        sites = getSites();
    }

    /**
     * Load config.yml from src/main/resources.
     */
    private static Map<String, Object> loadYaml() {
        InputStream inputStream = ConfigManager.class.getClassLoader().getResourceAsStream(CONFIG_FILE);
        return new Yaml().load(inputStream);
    }

    /**
     * Get sites section from config.yml.
     */
    private static Map<String, Object> getSites() {
        Object sitesConfig = config.get("sites");
        return (Map<String, Object>) sitesConfig;
    }

    /**
     * Set site for the current TestNG thread.
     *
     * Site must be provided from TestNG XML.
     */

    public static void setSite(String siteName) {

        Object siteObject = sites.get(siteName);

        /*
         * Create a separate copy for this thread.
         *
         * This prevents one parallel test from modifying
         * another test's configuration.
         */
        Map<String, Object> threadConfig = new HashMap<>((Map<String, Object>) siteObject);
        currentSiteConfig.set(threadConfig);

        // Load credentials from .env or CI environment variables
        String prefix = siteName.toUpperCase().replace("-", "_");
        addEnvironmentValue("username", prefix + "_USERNAME");
        addEnvironmentValue("password", prefix + "_PASSWORD");
        addEnvironmentValue("api_key", prefix + "_API_KEY");
    }

    private static void addEnvironmentValue(String configKey, String environmentVariable) {
        String value = dotenv.get(environmentVariable);
        if (value == null || value.isBlank()) {
            value = System.getenv(environmentVariable);
        }
        currentSiteConfig.get().put(configKey, value);
    }
    /**
     * Get configuration value for the current TestNG thread.
     */
    private static String getValue(String key) {
        Map<String, Object> siteConfig = currentSiteConfig.get();
        Object value = siteConfig.get(key);
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

    /**
     * Clear ThreadLocal configuration after the test class finishes.
     */
    public static void clearSiteConfig() {
        currentSiteConfig.remove();
    }
}