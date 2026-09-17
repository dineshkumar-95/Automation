package org.example.Interview.JavaCollectionsFramework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Group Anagrams Together: Group anagrams into sub-lists using HashMap&lt;String, List&lt;String&gt;&gt;
 * where the key is the sorted version of the word.
 * SDET: Grouping test logs/warnings with the same structural phrases but different order.
 */
public class Q07_GroupAnagrams {
    public static void main(String[] args) {
        String[] words = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println("Sorted key HashMap (best): " + groupUsingSortedKey(words));
        System.out.println("Count signature: " + groupUsingCountKey(words));
        System.out.println("Stream: " + groupUsingStream(words));
    }

    // Best common interview: sort chars as key — O(n * k log k)
    public static List<List<String>> groupUsingSortedKey(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        if (strs == null) {
            return List.of();
        }
        for (String word : strs) {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(map.values());
    }

    // Often faster for lowercase letters: count signature key — O(n * k)
    public static List<List<String>> groupUsingCountKey(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        if (strs == null) {
            return List.of();
        }
        for (String word : strs) {
            int[] count = new int[26];
            for (char c : word.toCharArray()) {
                count[c - 'a']++;
            }
            StringBuilder key = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                key.append('#').append(count[i]);
            }
            map.computeIfAbsent(key.toString(), k -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(map.values());
    }

    // Stream groupingBy
    public static List<List<String>> groupUsingStream(String[] strs) {
        if (strs == null) {
            return List.of();
        }
        return new ArrayList<>(Arrays.stream(strs)
                .collect(Collectors.groupingBy(word -> {
                    char[] chars = word.toCharArray();
                    Arrays.sort(chars);
                    return new String(chars);
                }))
                .values());
    }
}
