package org.example.Interview.StringManipulationQuestions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Anagram Check: Determine if two strings are anagrams of each other
 * (e.g., "listen" and "silent").
 */
public class Q04_AnagramCheck {
    public static void main(String[] args) {
        String s1 = "Listen";
        String s2 = "silent";

//        System.out.println("Frequency array (best): " + isAnagramUsingArray(s1, s2));
        System.out.println("HashMap: " + isAnagramUsingHashMap(s1, s2));
//        System.out.println("Sorting: " + isAnagramUsingSorting(s1, s2));
    }

    // Best for ASCII: O(n) time, O(1) space
    public static boolean isAnagramUsingArray(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        int[] count = new int[256];
        for (int i = 0; i < s1.length(); i++) {
//            count[Character.toLowerCase(s1.charAt(i))]++;
//            count[Character.toLowerCase(s2.charAt(i))]--;
            count[s1.charAt(i)]++;
            count[s2.charAt(i)]--;
//
        }
        for (int c : count) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }

    // Good for Unicode: O(n) time, O(k) space
    public static boolean isAnagramUsingHashMap(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        Map<Character, Integer> frequency = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            char c1 = Character.toLowerCase(s1.charAt(i));
            char c2 = Character.toLowerCase(s2.charAt(i));
            frequency.put(c1, frequency.getOrDefault(c1, 0) + 1);
            frequency.put(c2, frequency.getOrDefault(c2, 0) - 1);
        }
        for (int value : frequency.values()) {
            if (value != 0) {
                return false;
            }
        }
        return true;
    }

    // Least optimal: O(n log n) time, O(n) space
    public static boolean isAnagramUsingSorting(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length()) {
            return false;
        }
        char[] a = s1.toLowerCase().toCharArray();
        char[] b = s2.toLowerCase().toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        return Arrays.equals(a, b);
    }
}
