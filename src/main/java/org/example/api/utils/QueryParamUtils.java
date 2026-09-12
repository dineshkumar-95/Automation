package org.example.api.utils;

import java.util.Map;

/**
 * Reusable utility class for safely populating REST query parameter maps.
 */
public class QueryParamUtils {

    private QueryParamUtils() {
    }

    /**
     * Adds a key-value parameter to the map if the value is non-null.
     */
    public static void addParam(Map<String, Object> params, String key, Object value) {
        if (params != null && value != null) {
            params.put(key, value);
        }
    }
}
