package org.example.Interview.JavaCollectionsFramework;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Convert a Map into a List of Custom Objects: Dynamically convert Map&lt;String, String&gt;
 * into List&lt;ConfigObject&gt; using Java Streams.
 * SDET: Map Excel/JSON key-value params into strongly typed test object models.
 */
public class Q10_MapToCustomObjects {
    public static void main(String[] args) {
        Map<String, String> config = new LinkedHashMap<>();
        config.put("baseUrl", "https://api.example.com");
        config.put("timeout", "30");
        config.put("env", "qa");

        System.out.println("Stream map (best): " + convertUsingStream(config));
        System.out.println("Loop: " + convertUsingLoop(config));
        System.out.println("forEach: " + convertUsingForEach(config));
    }

    public static class ConfigObject {
        private final String key;
        private final String value;

        public ConfigObject(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "ConfigObject{key='" + key + "', value='" + value + "'}";
        }
    }

    // Best for this problem: Streams
    public static List<ConfigObject> convertUsingStream(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return List.of();
        }
        return map.entrySet().stream()
                .map(e -> new ConfigObject(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }

    public static List<ConfigObject> convertUsingLoop(Map<String, String> map) {
        List<ConfigObject> list = new ArrayList<>();
        if (map == null) {
            return list;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            list.add(new ConfigObject(entry.getKey(), entry.getValue()));
        }
        return list;
    }

    public static List<ConfigObject> convertUsingForEach(Map<String, String> map) {
        List<ConfigObject> list = new ArrayList<>();
        if (map == null) {
            return list;
        }
        map.forEach((k, v) -> list.add(new ConfigObject(k, v)));
        return list;
    }
}
