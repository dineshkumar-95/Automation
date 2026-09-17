package org.example.Interview.JavaCollectionsFramework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Sort HashMap: Sort a HashMap based on its values instead of its keys.
 */
public class Q03_SortHashMap {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("banana", 3);
        map.put("apple", 5);
        map.put("orange", 2);
        map.put("grape", 5);

        System.out.println("Stream sorted (best/modern): " + sortByValueUsingStream(map));
        System.out.println("List of entries + Collections.sort: " + sortByValueUsingList(map));
        System.out.println("Descending values: " + sortByValueDescending(map));
    }

    // Best modern approach: stream + LinkedHashMap to keep order — O(n log n)
    public static Map<String, Integer> sortByValueUsingStream(Map<String, Integer> map) {
        if (map == null || map.isEmpty()) {
            return new LinkedHashMap<>();
        }
        return map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> a,
                        LinkedHashMap::new));
    }

    // Classic interview approach: sort entry list, then rebuild — O(n log n)
    public static Map<String, Integer> sortByValueUsingList(Map<String, Integer> map) {
        Map<String, Integer> sorted = new LinkedHashMap<>();
        if (map == null || map.isEmpty()) {
            return sorted;
        }
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, Map.Entry.comparingByValue());
        for (Map.Entry<String, Integer> entry : entries) {
            sorted.put(entry.getKey(), entry.getValue());
        }
        return sorted;
    }

    // Sort by value descending
    public static Map<String, Integer> sortByValueDescending(Map<String, Integer> map) {
        if (map == null || map.isEmpty()) {
            return new LinkedHashMap<>();
        }
        return map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> a,
                        LinkedHashMap::new));
    }
}
