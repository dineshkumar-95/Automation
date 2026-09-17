package org.example.Interview.AutomationAndLogicalScenarios;

import java.net.URI;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * URL Parameter Extraction and Validation: Extract query parameters into Map&lt;String, String&gt;.
 * SDET: Assert OAuth flows, tracking params, campaigns, or cross-page state.
 */
public class Q11_UrlParameterExtraction {
    public static void main(String[] args) {
        String url = "https://example.com/callback?code=abc123&state=xyz&utm_source=qa&redirect=https%3A%2F%2Fapp.example.com";
        System.out.println("URI parse (best): " + extractUsingUri(url));
        System.out.println("Manual/regex: " + extractUsingRegex(url));
        System.out.println("Has code: " + extractUsingUri(url).get("code"));
    }

    // Best: java.net.URI then split query
    public static Map<String, String> extractUsingUri(String url) {
        Map<String, String> params = new LinkedHashMap<>();
        if (url == null || url.isBlank()) {
            return params;
        }
        URI uri = URI.create(url);
        String query = uri.getRawQuery();
        if (query == null || query.isEmpty()) {
            return params;
        }
        for (String pair : query.split("&")) {
            String[] kv = pair.split("=", 2);
            String key = decode(kv[0]);
            String value = kv.length > 1 ? decode(kv[1]) : "";
            params.put(key, value);
        }
        return params;
    }

    // Fallback without URI edge cases: regex on query section
    public static Map<String, String> extractUsingRegex(String url) {
        Map<String, String> params = new LinkedHashMap<>();
        if (url == null) {
            return params;
        }
        int q = url.indexOf('?');
        if (q < 0 || q == url.length() - 1) {
            return params;
        }
        String query = url.substring(q + 1);
        int hash = query.indexOf('#');
        if (hash >= 0) {
            query = query.substring(0, hash);
        }
        Matcher matcher = Pattern.compile("([^&=]+)=?([^&]*)").matcher(query);
        while (matcher.find()) {
            params.put(decode(matcher.group(1)), decode(matcher.group(2)));
        }
        return params;
    }

    public static boolean hasParam(String url, String key, String expectedValue) {
        Map<String, String> params = extractUsingUri(url);
        return expectedValue.equals(params.get(key));
    }

    private static String decode(String value) {
        return URLDecoder.decode(value, StandardCharsets.UTF_8);
    }
}
