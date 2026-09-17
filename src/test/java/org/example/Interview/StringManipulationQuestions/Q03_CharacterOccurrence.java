package org.example.Interview.StringManipulationQuestions;

import java.util.HashMap;
import java.util.Map;

/**
 * Character Occurrence: Count the occurrences of a specific character
 * or each character in a given string.
 */
public class Q03_CharacterOccurrence {
    public static void main(String[] args) {
        String str = "Programming";

        // Count a specific character
        char target = 'g';
        System.out.println("Count of '" + target + "' (loop): " + countSpecificChar(str, target));
        System.out.println("Count of '" + target + "' (stream): " + countSpecificCharUsingStream(str, target));

        // Count each character
        System.out.println("Each char (array - best for ASCII): ");
        printFrequencyArray(countEachCharUsingArray(str));
        System.out.println("Each char (HashMap): " + countEachChar(str));
    }

    // ----- Specific character -----

    // Best: O(n) time, O(1) space
    public static int countSpecificChar(String str, char target) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == target) {
                count++;
            }
        }
        return count;
    }

    // Stream API — concise, slight overhead
    public static long countSpecificCharUsingStream(String str, char target) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        return str.chars().filter(c -> c == target).count();
    }

    // ----- Each character -----

    // Best for ASCII: O(n) time, O(1) space
    public static int[] countEachCharUsingArray(String str) {
        int[] frequency = new int[256];
        if (str == null || str.isEmpty()) {
            return frequency;
        }
        for (int i = 0; i < str.length(); i++) {
            frequency[str.charAt(i)]++;
        }
        return frequency;
    }

    // Good for Unicode: O(n) time, O(k) space
    public static Map<Character, Integer> countEachChar(String str) {
        Map<Character, Integer> frequency = new HashMap<>();
        if (str == null || str.isEmpty()) {
            return frequency;
        }
        for (char c : str.toCharArray()) {
            frequency.put(c, frequency.getOrDefault(c, 0) + 1);
        }
        return frequency;
    }

    private static void printFrequencyArray(int[] frequency) {
        for (int i = 0; i < frequency.length; i++) {
            if (frequency[i] > 0) {
                System.out.println((char) i + " -> " + frequency[i]);
            }
        }
    }
}
