package org.example.config;

import io.github.cdimascio.dotenv.Dotenv;

public class ConfigManager {

    private static final Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
    private static final ThreadLocal<String> currentSite = new ThreadLocal<>();

    public static void setSite(String siteName) {

        if (siteName == null || siteName.isBlank()) {
            throw new IllegalArgumentException("siteName must be provided from TestNG XML");
        }
        currentSite.set(siteName);
    }

    private static String getValue(String key) {

        String site = currentSite.get();
        if (site == null) {
            throw new IllegalStateException("Site has not been initialized. " + "Call ConfigManager.setSite(siteName) first.");
        }
        String envKey = site.toUpperCase().replace("-", "_") + "_" + key;
        String value = dotenv.get(envKey);

        /*
         * .env is used locally.
         * System.getenv() is used in CI/GitHub Actions.
         */
        if (value == null || value.isBlank()) {
            value = System.getenv(envKey);
        }

        if (value == null || value.isBlank()) {
            throw new RuntimeException("Configuration not found: " + envKey);
        }

        return value;
    }

    public static String getSiteUrl() {
        return getValue("SITE_URL");
    }

    public static String getApiBaseUri() {
        return getValue("API_BASE_URI");
    }

    public static String getUsername() {
        return getValue("USERNAME");
    }

    public static String getPassword() {
        return getValue("PASSWORD");
    }

    public static String getApiKey() {
        return getValue("API_KEY");
    }

    public static String getCurrentSite() {
        return currentSite.get();
    }

    public static void clear() {
        currentSite.remove();
    }
}