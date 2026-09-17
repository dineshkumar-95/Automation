package org.example.Interview.JavaCollectionsFramework;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Count Word Frequency: Read a sentence and use a HashMap to count how many times each word appears.
 */
public class Q01_CountWordFrequency {
    public static void main(String[] args) {
        String sentence = "Java is great and Java is powerful";
        System.out.println("HashMap (best): " + countUsingHashMap(sentence));
        System.out.println("LinkedHashMap (insertion order): " + countUsingLinkedHashMap(sentence));
        System.out.println("Stream groupingBy: " + countUsingStream(sentence));
    }

    // Best interview pick: HashMap — O(n) time average
    public static Map<String, Integer> countUsingHashMap(String sentence) {
        Map<String, Integer> frequency = new HashMap<>();
        if (sentence == null || sentence.isBlank()) {
            return frequency;
        }
        for (String word : sentence.trim().toLowerCase().split("\\s+")) {
            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }
        return frequency;
    }

    // Preserves first-seen word order
    public static Map<String, Integer> countUsingLinkedHashMap(String sentence) {
        Map<String, Integer> frequency = new LinkedHashMap<>();
        if (sentence == null || sentence.isBlank()) {
            return frequency;
        }
        for (String word : sentence.trim().toLowerCase().split("\\s+")) {
            frequency.merge(word, 1, Integer::sum);
        }
        return frequency;
    }

    // Stream API — concise, slight overhead
    public static Map<String, Long> countUsingStream(String sentence) {
        if (sentence == null || sentence.isBlank()) {
            return Map.of();
        }
        return java.util.Arrays.stream(sentence.trim().toLowerCase().split("\\s+"))
                .collect(Collectors.groupingBy(w -> w, Collectors.counting()));
    }
}
