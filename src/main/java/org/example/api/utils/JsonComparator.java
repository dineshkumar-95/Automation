package org.example.api.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.regex.Pattern;

/**
 * Utility class for comparing JSON structures.
 * Provides methods to compare JSON files, strings, and API responses.
 * Supports field exclusion, array order independence, and array wildcards.
 */
public class JsonComparator {

    private static final ObjectMapper mapper = new ObjectMapper();

    /**
     * Compares two JSON files for exact match
     */
    public static void compareJsonFiles(String filePath1, String filePath2) throws IOException {
        compareJsonFiles(filePath1, filePath2, null);
    }

    /**
     * Compares two JSON files for exact match, ignoring specified fields
     */
    public static void compareJsonFiles(String filePath1, String filePath2, List<String> ignoreFields) throws IOException {
        JsonNode json1 = mapper.readTree(new File(filePath1));
        JsonNode json2 = mapper.readTree(new File(filePath2));
        
        Set<String> ignoreSet = ignoreFields != null ? new HashSet<>(ignoreFields) : null;
        assertJsonEquals(json1, json2, ignoreSet, "");
    }

    /**
     * Compares API response JSON with expected JSON file
     */
    public static void compareJsonWithFile(Response response, String expectedJsonFilePath) throws IOException {
        compareJsonWithFile(response, expectedJsonFilePath, null);
    }

    /**
     * Compares API response JSON with expected JSON file, ignoring specified fields
     */
    public static void compareJsonWithFile(Response response, String expectedJsonFilePath, List<String> ignoreFields) throws IOException {
        JsonNode expectedJson = mapper.readTree(new File(expectedJsonFilePath));
        JsonNode actualJson = mapper.readTree(response.asString());
        
        Set<String> ignoreSet = ignoreFields != null ? new HashSet<>(ignoreFields) : null;
        assertJsonEquals(expectedJson, actualJson, ignoreSet, "");
    }

    /**
     * Compares API response JSON with expected JSON from classpath resources
     */
    public static void compareJsonWithClasspathResource(Response response, String classpathResourcePath) throws IOException {
        compareJsonWithClasspathResource(response, classpathResourcePath, null);
    }

    /**
     * Compares API response JSON with expected JSON from classpath resources, ignoring specified fields
     */
    public static void compareJsonWithClasspathResource(Response response, String classpathResourcePath, List<String> ignoreFields) throws IOException {
        InputStream inputStream = JsonComparator.class.getClassLoader().getResourceAsStream(classpathResourcePath);
        
        if (inputStream == null) {
            Assert.fail("Classpath resource not found: " + classpathResourcePath);
        }
        
        JsonNode expectedJson = mapper.readTree(inputStream);
        JsonNode actualJson = mapper.readTree(response.asString());
        
        Set<String> ignoreSet = ignoreFields != null ? new HashSet<>(ignoreFields) : null;
        assertJsonEquals(expectedJson, actualJson, ignoreSet, "");
    }

    /**
     * Compares two JSON strings with detailed mismatch reporting
     */
    public static void compareJsonStrings(String json1, String json2, String errorMessage) throws IOException {
        compareJsonStrings(json1, json2, errorMessage, null);
    }

    /**
     * Compares two JSON strings with detailed mismatch reporting, ignoring specified fields
     */
    public static void compareJsonStrings(String json1, String json2, String errorMessage, List<String> ignoreFields) throws IOException {
        JsonNode node1 = mapper.readTree(json1);
        JsonNode node2 = mapper.readTree(json2);
        
        Set<String> ignoreSet = ignoreFields != null ? new HashSet<>(ignoreFields) : null;
        try {
            assertJsonEquals(node1, node2, ignoreSet, "");
        } catch (AssertionError e) {
            String differences = findJsonDifferences(node1, node2, ignoreSet, "");
            throw new AssertionError(errorMessage + "\nDifferences:\n" + differences);
        }
    }

    /**
     * Main method to assert JSON equality with field exclusion support
     */
    private static void assertJsonEquals(JsonNode expected, JsonNode actual, Set<String> ignoreFields, String path) {
        if (expected == null && actual == null)
            return;
        if (expected == null || actual == null) {
            throw new AssertionError("JSON comparison failed at path '" + path + "': one node is null");
        }
        
        if (expected.isObject() && actual.isObject()) {
            compareJsonObject(expected, actual, ignoreFields, path);
        } else if (expected.isArray() && actual.isArray()) {
            compareJsonArray(expected, actual, ignoreFields, path);
        } else {
            // Primitive value comparison - check if should be ignored
            if (!shouldIgnoreField(path, ignoreFields)) {
                if (!expected.equals(actual)) {
                    throw new AssertionError("Field '" + path + "' mismatch: expected '" + expected + "', but was '" + actual + "'");
                }
            }
        }
    }

    /**
     * Finds differences between two JSON nodes
     */
    private static String findJsonDifferences(JsonNode node1, JsonNode node2) {
        return findJsonDifferences(node1, node2, null, "");
    }

    /**
     * Finds differences between two JSON nodes, ignoring specified fields
     */
    private static String findJsonDifferences(JsonNode node1, JsonNode node2, Set<String> ignoreFields, String path) {
        StringBuilder differences = new StringBuilder();
        
        if (node1.isObject() && node2.isObject()) {
            compareJsonObject(node1, node2, differences, ignoreFields, path);
        } else if (node1.isArray() && node2.isArray()) {
            compareJsonArray(node1, node2, differences, ignoreFields, path);
        } else if (!node1.equals(node2)) {
            differences.append("Value mismatch: expected '").append(node1)
                       .append("', but was '").append(node2).append("'\n");
        }
        
        return differences.toString();
    }

    /**
     * Compares two JSON objects
     */
    private static void compareJsonObject(JsonNode obj1, JsonNode obj2, StringBuilder differences, String path) {
        compareJsonObject(obj1, obj2, differences, null, path);
    }

    /**
     * Compares two JSON objects, ignoring specified fields
     */
    private static void compareJsonObject(JsonNode obj1, JsonNode obj2, StringBuilder differences, Set<String> ignoreFields, String path) {
        Iterator<Map.Entry<String, JsonNode>> fields1 = obj1.fields();
        Iterator<Map.Entry<String, JsonNode>> fields2 = obj2.fields();
        
        while (fields1.hasNext()) {
            Map.Entry<String, JsonNode> entry = fields1.next();
            String key = entry.getKey();
            JsonNode value1 = entry.getValue();
            JsonNode value2 = obj2.get(key);
            
            String currentPath = path.isEmpty() ? key : path + "." + key;
            
            // Skip if this field should be ignored
            if (shouldIgnoreField(currentPath, ignoreFields)) {
                continue;
            }
            
            if (value2 == null) {
                differences.append("Missing field in actual: '").append(currentPath).append("'\n");
            } else if (!value1.equals(value2)) {
                if (value1.isObject() && value2.isObject()) {
                    compareJsonObject(value1, value2, differences, ignoreFields, currentPath);
                } else if (value1.isArray() && value2.isArray()) {
                    compareJsonArray(value1, value2, differences, ignoreFields, currentPath);
                } else {
                    differences.append("Field '").append(currentPath).append("' mismatch: expected '")
                               .append(value1).append("', but was '").append(value2).append("'\n");
                }
            }
        }
        
        // Check for extra fields in actual
        while (fields2.hasNext()) {
            Map.Entry<String, JsonNode> entry = fields2.next();
            String key = entry.getKey();
            String currentPath = path.isEmpty() ? key : path + "." + key;
            
            // Skip if this field should be ignored
            if (shouldIgnoreField(currentPath, ignoreFields)) {
                continue;
            }
            
            if (!obj1.has(key)) {
                differences.append("Extra field in actual: '").append(currentPath).append("'\n");
            }
        }
    }

    /**
     * Compares two JSON objects and returns true if they match (ignoring specified fields)
     */
    private static boolean compareJsonObject(JsonNode obj1, JsonNode obj2, Set<String> ignoreFields, String path) {
        Iterator<Map.Entry<String, JsonNode>> fields1 = obj1.fields();
        Iterator<Map.Entry<String, JsonNode>> fields2 = obj2.fields();
        
        while (fields1.hasNext()) {
            Map.Entry<String, JsonNode> entry = fields1.next();
            String key = entry.getKey();
            JsonNode value1 = entry.getValue();
            JsonNode value2 = obj2.get(key);
            
            String currentPath = path.isEmpty() ? key : path + "." + key;
            
            // Skip if this field should be ignored
            if (shouldIgnoreField(currentPath, ignoreFields)) {
                continue;
            }
            
            if (value2 == null) {
                throw new AssertionError("Missing field in actual: '" + currentPath + "'");
            }
            
            if (!value1.equals(value2)) {
                // For primitive values, throw specific error immediately
                if (!value1.isObject() && !value1.isArray()) {
                    throw new AssertionError("Field '" + currentPath + "' mismatch: expected '" + value1 + "', but was '" + value2 + "'");
                } else {
                    // For nested objects/arrays, continue comparison
                    try {
                        assertJsonEquals(value1, value2, ignoreFields, currentPath);
                    } catch (AssertionError e) {
                        throw new AssertionError("Field '" + currentPath + "' contains mismatch: " + e.getMessage());
                    }
                }
            }
        }
        
        // Check for extra fields in actual
        while (fields2.hasNext()) {
            Map.Entry<String, JsonNode> entry = fields2.next();
            String key = entry.getKey();
            String currentPath = path.isEmpty() ? key : path + "." + key;
            
            // Skip if this field should be ignored
            if (shouldIgnoreField(currentPath, ignoreFields)) {
                continue;
            }
            
            if (!obj1.has(key)) {
                throw new AssertionError("Extra field in actual: '" + currentPath + "'");
            }
        }
        
        return true;
    }

    /**
     * Compares two JSON arrays
     */
    private static void compareJsonArray(JsonNode arr1, JsonNode arr2, StringBuilder differences, String path) {
        compareJsonArray(arr1, arr2, differences, null, path);
    }

    /**
     * Compares two JSON arrays, ignoring specified fields
     */
    private static void compareJsonArray(JsonNode arr1, JsonNode arr2, StringBuilder differences, Set<String> ignoreFields, String path) {
        if (arr1.size() != arr2.size()) {
            differences.append("Array '").append(path).append("' size mismatch: expected ")
                       .append(arr1.size()).append(", but was ").append(arr2.size()).append("\n");
            return;
        }
        
        for (int i = 0; i < arr1.size(); i++) {
            JsonNode elem1 = arr1.get(i);
            JsonNode elem2 = arr2.get(i);
            String currentPath = path + "[" + i + "]";
            
            if (!elem1.equals(elem2)) {
                if (elem1.isObject() && elem2.isObject()) {
                    compareJsonObject(elem1, elem2, differences, ignoreFields, currentPath);
                } else if (elem1.isArray() && elem2.isArray()) {
                    compareJsonArray(elem1, elem2, differences, ignoreFields, currentPath);
                } else {
                    differences.append("Array element '").append(currentPath).append("' mismatch: expected '")
                               .append(elem1).append("', but was '").append(elem2).append("'\n");
                }
            }
        }
    }

    /**
     * Compares two JSON arrays (main comparison method) with order independence support
     */
    private static void compareJsonArray(JsonNode arr1, JsonNode arr2, Set<String> ignoreFields, String path) {
        if (arr1.size() != arr2.size()) {
            throw new AssertionError("Array '" + path + "' size mismatch: expected " + arr1.size() + ", but was " + arr2.size());
        }
        
        // Try order-independent comparison first
        if (isArrayOrderIndependent(arr1, arr2, ignoreFields, path)) {
            return;
        }
        
        // Fall back to order-dependent comparison
        for (int i = 0; i < arr1.size(); i++) {
            JsonNode elem1 = arr1.get(i);
            JsonNode elem2 = arr2.get(i);
            String currentPath = path + "[" + i + "]";
            
            try {
                assertJsonEquals(elem1, elem2, ignoreFields, currentPath);
            } catch (AssertionError e) {
                throw new AssertionError("Array element '" + currentPath + "' mismatch: " + e.getMessage());
            }
        }
    }

    /**
     * Attempts order-independent array comparison by matching elements
     */
    private static boolean isArrayOrderIndependent(JsonNode arr1, JsonNode arr2, Set<String> ignoreFields, String path) {
        // If arrays are empty or single element, order doesn't matter
        if (arr1.size() <= 1) {
            return true;
        }

        // Try to find unique identifier field for matching
        String idField = findUniqueIdField(arr1);
        if (idField == null) {
            return false; // No unique ID found, fall back to order-dependent
        }

        // Create maps based on unique ID
        Map<String, JsonNode> expectedMap = new LinkedHashMap<>();
        Map<String, JsonNode> actualMap = new LinkedHashMap<>();

        for (JsonNode elem : arr1) {
            if (elem.has(idField)) {
                expectedMap.put(elem.get(idField).asText(), elem);
            }
        }

        for (JsonNode elem : arr2) {
            if (elem.has(idField)) {
                actualMap.put(elem.get(idField).asText(), elem);
            }
        }

        // Check if all IDs match
        if (!expectedMap.keySet().equals(actualMap.keySet())) {
            return false;
        }

        // Compare elements by matching IDs
        for (String id : expectedMap.keySet()) {
            JsonNode expectedElem = expectedMap.get(id);
            JsonNode actualElem = actualMap.get(id);
            String currentPath = path + "[id=" + id + "]";

            try {
                assertJsonEquals(expectedElem, actualElem, ignoreFields, currentPath);
            } catch (AssertionError e) {
                throw new AssertionError("Array element '" + currentPath + "' mismatch: " + e.getMessage());
            }
        }

        return true;
    }

    /**
     * Finds a unique identifier field in array elements
     */
    private static String findUniqueIdField(JsonNode array) {
        if (array.size() == 0) return null;

        JsonNode firstElem = array.get(0);
        if (!firstElem.isObject()) return null;

        // Common ID field names to try
        String[] idFields = {"id", "item_price_id", "line_item_id", "subscription_id", "customer_id", "entity_id"};

        for (String idField : idFields) {
            if (firstElem.has(idField)) {
                // Check if this field has unique values across all elements
                Set<String> values = new HashSet<>();
                boolean allUnique = true;
                for (JsonNode elem : array) {
                    if (elem.has(idField)) {
                        String value = elem.get(idField).asText();
                        if (values.contains(value)) {
                            allUnique = false;
                            break;
                        }
                        values.add(value);
                    } else {
                        allUnique = false;
                        break;
                    }
                }
                if (allUnique && values.size() == array.size()) {
                    return idField;
                }
            }
        }

        return null;
    }

    /**
     * Checks if a field should be ignored based on the ignore fields set
     * Supports both exact field names, path-based matching, and array wildcards
     */
    private static boolean shouldIgnoreField(String fieldPath, Set<String> ignoreFields) {
        if (ignoreFields == null || ignoreFields.isEmpty()) {
            return false;
        }
        
        // Check exact match
        if (ignoreFields.contains(fieldPath)) {
            return true;
        }
        
        // Check if any ignore pattern matches
        for (String ignorePattern : ignoreFields) {
            // Handle object wildcards like "customer.*"
            if (ignorePattern.endsWith(".*")) {
                String prefix = ignorePattern.substring(0, ignorePattern.length() - 2);
                if (fieldPath.equals(prefix) || fieldPath.startsWith(prefix + ".")) {
                    return true;
                }
            }
            
            // Handle array wildcards like "subscription_items[*].created_at"
            if (ignorePattern.contains("[*]")) {
                if (matchesArrayWildcard(fieldPath, ignorePattern)) {
                    return true;
                }
            }
        }
        
        return false;
    }

    /**
     * Checks if a field path matches an array wildcard pattern
     * Example: "subscription.subscription_items[0].created_at" matches "subscription.subscription_items[*].created_at"
     * Also handles ID-based paths like "subscription.subscription_items[id=abc].created_at"
     */
    private static boolean matchesArrayWildcard(String fieldPath, String pattern) {
        // Handle numeric array indices like [0], [1], etc.
        String numericPattern = pattern.replace("[*]", "\\[\\d+\\]");
        numericPattern = numericPattern.replace(".", "\\.");
        Pattern compiledNumericPattern = Pattern.compile("^" + numericPattern + "$");
        if (compiledNumericPattern.matcher(fieldPath).matches()) {
            return true;
        }
        
        // Handle ID-based array indices like [id=abc123]
        String idPattern = pattern.replace("[*]", "\\[id=[^\\]]+\\]");
        idPattern = idPattern.replace(".", "\\.");
        Pattern compiledIdPattern = Pattern.compile("^" + idPattern + "$");
        if (compiledIdPattern.matcher(fieldPath).matches()) {
            return true;
        }
        
        return false;
    }
}