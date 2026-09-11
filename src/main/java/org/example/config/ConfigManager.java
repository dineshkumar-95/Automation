package org.example.config;

import org.yaml.snakeyaml.Yaml;
import io.github.cdimascio.dotenv.Dotenv;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class ConfigManager {
    private static final String CONFIG_FILE = "config.yml";
    private static final String CI_ENV_VAR = "CI";
    private static Map<String, Object> config;
    private static Map<String, Object> sites;
    private static String currentSite;
    private static Map<String, Object> currentSiteConfig;
    private static Dotenv dotenv;

    static {
        loadConfiguration();
    }

    private static void loadConfiguration() {
        boolean isCI = System.getenv(CI_ENV_VAR) != null && System.getenv(CI_ENV_VAR).equalsIgnoreCase("true");
        
        // Load .env file for local development (not in CI)
        if (!isCI) {
            try {
                dotenv = Dotenv.configure()
                    .ignoreIfMissing()
                    .load();
                System.out.println("Loaded .env file successfully");
            } catch (Exception e) {
                System.out.println("Warning: Could not load .env file - " + e.getMessage());
            }
        }
        
        // Load URLs from YAML
        loadFromYamlFile();
        
        // Merge credentials from environment variables
        mergeCredentialsFromEnvironmentVariables();
    }

    private static void loadFromYamlFile() {
        try {
            Yaml yaml = new Yaml();
            InputStream inputStream = ConfigManager.class.getClassLoader().getResourceAsStream(CONFIG_FILE);
            if (inputStream == null) {
                throw new RuntimeException("Configuration file not found: " + CONFIG_FILE);
            }
            config = yaml.load(inputStream);
            sites = (Map<String, Object>) config.get("sites");
            String defaultSite = (String) config.get("default");
            currentSite = defaultSite;
            currentSiteConfig = new HashMap<>((Map<String, Object>) sites.get(defaultSite));
        } catch (Exception e) {
            throw new RuntimeException("Failed to load configuration from YAML file", e);
        }
    }

    private static void mergeCredentialsFromEnvironmentVariables() {
        String prefix = currentSite.toUpperCase().replace("-", "_") + "_";
        
        // Add credentials from environment variables if available
        String username = getEnvVar(prefix + "USERNAME");
        if (username != null) {
            currentSiteConfig.put("username", username);
            System.out.println("Loaded username for site: " + currentSite);
        }
        
        String password = getEnvVar(prefix + "PASSWORD");
        if (password != null) {
            currentSiteConfig.put("password", password);
            System.out.println("Loaded password for site: " + currentSite);
        }
        
        String apiKey = getEnvVar(prefix + "API_KEY");
        if (apiKey != null) {
            currentSiteConfig.put("api_key", apiKey);
            System.out.println("Loaded API key for site: " + currentSite);
        } else {
            System.out.println("Warning: API key not found for site: " + currentSite);
            System.out.println("Looking for environment variable: " + prefix + "API_KEY");
        }
    }

    private static String getEnvVar(String name) {
        // Try dotenv first (for local development with .env file)
        if (dotenv != null) {
            String value = dotenv.get(name);
            if (value != null && !value.isEmpty()) {
                return value;
            }
        }
        // Fall back to System.getenv (for CI/CD)
        return System.getenv(name);
    }

    private static String getEnvVar(String name, String defaultValue) {
        String value = getEnvVar(name);
        return value != null ? value : defaultValue;
    }

    public static void setSite(String siteName) {
        if (siteName == null || siteName.isEmpty() || siteName.equals("${siteName}")) {
            // No site specified, keep current/default configuration
            return;
        }
        
        if (sites.containsKey(siteName)) {
            currentSite = siteName;
            currentSiteConfig = new HashMap<>((Map<String, Object>) sites.get(siteName));
            mergeCredentialsFromEnvironmentVariables();
        } else {
            throw new RuntimeException("Site not found in configuration: " + siteName);
        }
    }

    public static String getUsername() {
        String username = (String) currentSiteConfig.get("username");
        if (username == null) {
            throw new RuntimeException("Username not found in configuration for site: " + currentSite);
        }
        return username;
    }

    public static String getPassword() {
        String password = (String) currentSiteConfig.get("password");
        if (password == null) {
            throw new RuntimeException("Password not found in configuration for site: " + currentSite);
        }
        return password;
    }

    public static String getSiteUrl() {
        String siteUrl = (String) currentSiteConfig.get("site_url");
        if (siteUrl == null) {
            throw new RuntimeException("Site URL not found in configuration for site: " + currentSite);
        }
        return siteUrl;
    }

    public static String getApiBaseUri() {
        String apiBaseUri = (String) currentSiteConfig.get("api_base_uri");
        if (apiBaseUri == null) {
            throw new RuntimeException("API base URI not found in configuration for site: " + currentSite);
        }
        return apiBaseUri;
    }

    public static String getApiKey() {
        String apiKey = (String) currentSiteConfig.get("api_key");
        if (apiKey == null) {
            throw new RuntimeException("API key not found in configuration for site: " + currentSite);
        }
        return apiKey;
    }

    public static String getCurrentSite() {
        return currentSite;
    }
}