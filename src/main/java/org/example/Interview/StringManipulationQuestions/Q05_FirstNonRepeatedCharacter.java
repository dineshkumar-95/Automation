package org.example.Interview.StringManipulationQuestions;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * First Non-Repeated Character: Find the first character in a string
 * that does not repeat anywhere else.
 */
public class Q05_FirstNonRepeatedCharacter {
    public static void main(String[] args) {
        String str = "swiss";
        System.out.println("Array (best for ASCII): " + firstNonRepeatedUsingArray(str));
        System.out.println("LinkedHashMap: " + firstNonRepeatedUsingLinkedHashMap(str));
        System.out.println("IndexOf/lastIndexOf: " + firstNonRepeatedUsingIndexOf(str));
    }

    // Best for ASCII: two passes — O(n) time, O(1) space
    public static Character firstNonRepeatedUsingArray(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        int[] count = new int[256];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (count[str.charAt(i)] == 1) {
                return str.charAt(i);
            }
        }
        return null;
    }

    // Good for Unicode, preserves insertion order — O(n) time, O(k) space
    public static Character firstNonRepeatedUsingLinkedHashMap(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        Map<Character, Integer> frequency = new LinkedHashMap<>();
        for (char c : str.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : frequency.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return null;
    }

    // Least optimal: O(n^2) time, O(1) space
    public static Character firstNonRepeatedUsingIndexOf(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (str.indexOf(c) == str.lastIndexOf(c)) {
                return c;
            }
        }
        return null;
    }
}
