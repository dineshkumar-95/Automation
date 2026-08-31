package org.example.Interview.StringManipulationQuestions;

import java.util.ArrayList;
import java.util.List;

/**
 * Find All Substrings / Palindromic Substrings: Find all possible substrings of a
 * given string, or count how many of those substrings are valid palindromes.
 * SDET: Bruteforce data-driven testing scenarios and boundary-value verification.
 */
public class Q10_PalindromicSubstrings {
    public static void main(String[] args) {
        String str = "aaa";
        System.out.println("Expand around center (best count): " + countPalindromicSubstrings(str));
        System.out.println("All substrings: " + findAllSubstrings(str));
        System.out.println("Brute force palindrome count: " + countPalindromesBruteForce(str));
    }

    // Best: expand around each center — O(n^2) time, O(1) space
    public static int countPalindromicSubstrings(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            count += expandAroundCenter(str, i, i);     // odd length
            count += expandAroundCenter(str, i, i + 1); // even length
        }
        return count;
    }

    // Generate all substrings — O(n^2) results, O(n^3) if materializing strings naively
    public static List<String> findAllSubstrings(String str) {
        List<String> substrings = new ArrayList<>();
        if (str == null || str.isEmpty()) {
            return substrings;
        }
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                substrings.add(str.substring(i, j));
            }
        }
        return substrings;
    }

    // Least optimal for count: check every substring — O(n^3) time
    public static int countPalindromesBruteForce(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j <= str.length(); j++) {
                if (isPalindrome(str, i, j - 1)) {
                    count++;
                }
            }
        }
        return count;
    }

    private static int expandAroundCenter(String str, int left, int right) {
        int count = 0;
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }

    private static boolean isPalindrome(String str, int left, int right) {
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
