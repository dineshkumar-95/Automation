package org.example.Interview.JavaCollectionsFramework;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Find All Duplicates and Their Frequency: Extract elements that appear more than once
 * with exact counts using a single-pass HashMap.
 * SDET: Flag duplicate order IDs / tracking numbers on a dashboard.
 */
public class Q11_DuplicatesWithFrequency {
    public static void main(String[] args) {
        List<String> items = List.of("ORD-1", "ORD-2", "ORD-1", "ORD-3", "ORD-2", "ORD-1");
        System.out.println("Single-pass HashMap (best): " + findDuplicatesWithFrequency(items));
        System.out.println("Stream filter: " + findDuplicatesUsingStream(items));
    }

    // Best: one pass count, then keep freq > 1 — O(n)
    public static Map<String, Integer> findDuplicatesWithFrequency(List<String> items) {
        Map<String, Integer> duplicates = new LinkedHashMap<>();
        if (items == null || items.isEmpty()) {
            return duplicates;
        }
        Map<String, Integer> frequency = new HashMap<>();
        for (String item : items) {
            frequency.put(item, frequency.getOrDefault(item, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : frequency.entrySet()) {
            if (entry.getValue() > 1) {
                duplicates.put(entry.getKey(), entry.getValue());
            }
        }
        return duplicates;
    }

    // Stream version
    public static Map<String, Long> findDuplicatesUsingStream(List<String> items) {
        if (items == null || items.isEmpty()) {
            return Map.of();
        }
        return items.stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (a, b) -> a, LinkedHashMap::new));
    }
}
