package org.example.Interview.AutomationAndLogicalScenarios;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Parse Dynamic JSON-like API Response Strings: Extract keys from payloads like
 * "{status:200, executionTime:450ms, id:TR-8821}" and validate types without Jackson/Gson.
 * SDET: Lightweight backend assertions when a full JSON library is not feasible.
 */
public class Q05_ParseDynamicJsonLikeResponse {
    public static void main(String[] args) {
        String payload = "{status:200, executionTime:450ms, id:TR-8821}";
        Map<String, String> map = parseUsingRegex(payload);
        System.out.println("Parsed map: " + map);
        System.out.println("status is int: " + isInteger(map.get("status")));
        System.out.println("executionTime numeric prefix: " + extractLeadingInt(map.get("executionTime")));
        System.out.println("id is alphanumeric id: " + isAlphanumericId(map.get("id")));
        System.out.println("Manual parse: " + parseManually(payload));
    }

    // Best: regex key:value pairs
    public static Map<String, String> parseUsingRegex(String payload) {
        Map<String, String> result = new HashMap<>();
        if (payload == null || payload.isBlank()) {
            return result;
        }
        Matcher matcher = Pattern.compile("(\\w+)\\s*:\\s*([^,}]+)").matcher(payload);
        while (matcher.find()) {
            result.put(matcher.group(1).trim(), matcher.group(2).trim());
        }
        return result;
    }

    // Strip braces/split — no regex engine needed
    public static Map<String, String> parseManually(String payload) {
        Map<String, String> result = new HashMap<>();
        if (payload == null || payload.isBlank()) {
            return result;
        }
        String body = payload.trim();
        if (body.startsWith("{")) {
            body = body.substring(1);
        }
        if (body.endsWith("}")) {
            body = body.substring(0, body.length() - 1);
        }
        for (String part : body.split(",")) {
            String[] kv = part.split(":", 2);
            if (kv.length == 2) {
                result.put(kv[0].trim(), kv[1].trim());
            }
        }
        return result;
    }

    public static boolean isInteger(String value) {
        if (value == null) {
            return false;
        }
        return value.matches("-?\\d+");
    }

    public static Integer extractLeadingInt(String value) {
        if (value == null) {
            return null;
        }
        Matcher matcher = Pattern.compile("-?\\d+").matcher(value);
        return matcher.find() ? Integer.parseInt(matcher.group()) : null;
    }

    public static boolean isAlphanumericId(String value) {
        return value != null && value.matches("[A-Za-z0-9-]+");
    }
}
