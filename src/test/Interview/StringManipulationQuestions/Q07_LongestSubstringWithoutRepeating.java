package org.example.Interview.StringManipulationQuestions;

import java.util.*;

/**
 * Longest Substring Without Repeating Characters: Find the length of the longest
 * substring without any repeating characters. Example: "abcabcbb" → "abc", length 3.
 * SDET: Testing UI field validations for unique input constraints.
 */
public class Q07_LongestSubstringWithoutRepeating {
    public static void main(String[] args) {
        String str = "abcddcfadbbeade";
        //System.out.println("Sliding window + Map (best): " + lengthOfLongestSubstringUsingMap(str));
        System.out.println("Sliding window + Set: " + lengthOfLongestSubstringUsingSet(str));
        System.out.println("Brute force: " + lengthOfLongestSubstringBruteForce(str));
    }

    // Best: sliding window with last-seen index — O(n) time, O(k) space
    public static int lengthOfLongestSubstringUsingMap(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        Map<Character, Integer> lastIndex = new HashMap<>();
        int maxLen = 0;
        int left = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (lastIndex.containsKey(c) && lastIndex.get(c) >= left) {
                left = lastIndex.get(c) + 1;
            }
            lastIndex.put(c, i);
            maxLen = Math.max(maxLen, i - left + 1);
        }
        return maxLen;
    }

    // Sliding window with Set — O(n) time, may shrink more slowly
    public static int lengthOfLongestSubstringUsingSet(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        Set<Character> Set = new HashSet<>();
        int maxLen = 0;
        int left = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            while (Set.contains(c)) {
                Set.remove(str.charAt(left));
                left++;
            }
            Set.add(c);
            maxLen = Math.max(maxLen, i - left + 1);
        }
        return maxLen;
    }

    // Least optimal: check every substring — O(n^2) / O(n^3) time
    public static int lengthOfLongestSubstringBruteForce(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        int maxLen = 0;
        for (int i = 0; i < str.length(); i++) {
            Set<Character> seen = new HashSet<>();
            for (int j = i; j < str.length(); j++) {
                if (seen.contains(str.charAt(j))) {
                    break;
                }
                seen.add(str.charAt(j));
                maxLen = Math.max(maxLen, j - i + 1);
            }
        }
        return maxLen;
    }
    public static int lengthOfLongestSubstringUsingSetWhileLoop(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }

        Set<Character> window = new HashSet<>();
        int maxLen = 0;
        int left = 0;
        int right = 0;

        while (right < str.length()) {
            char current = str.charAt(right);

            if (!window.contains(current)) {
                // 1. If the character is unique, add it to our window
                window.add(current);
                // 2. Measure the window size and update maxLen
                maxLen = Math.max(maxLen, right - left + 1);
                // 3. Move the right pointer forward
                right++;
            } else {
                // 1. Found a duplicate! Shrink window from the left
                window.remove(str.charAt(left));
                // 2. Move left pointer forward to try again
                left++;
            }
        }
        return maxLen;
    }

}
