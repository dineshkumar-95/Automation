package org.example.Interview.StringManipulationQuestions;

/**
 * Longest Common Prefix: Find the longest common prefix amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 * SDET: Aggregating dynamic test IDs or URLs to find base endpoints in microservice testing.
 */
public class Q12_LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println("Vertical scan (best): " + longestCommonPrefixVertical(strs));
        System.out.println("Horizontal scan: " + longestCommonPrefixHorizontal(strs));
        System.out.println("Sort + compare ends: " + longestCommonPrefixUsingSort(strs));
    }

    // Best typical interview pick: compare column by column — O(S) where S = all chars
    public static String longestCommonPrefixVertical(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    // Shrink prefix against each next string — O(S)
    public static String longestCommonPrefixHorizontal(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    // Sort then compare first and last — O(n log n) due to sort
    public static String longestCommonPrefixUsingSort(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        java.util.Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        int i = 0;
        while (i < first.length() && i < last.length() && first.charAt(i) == last.charAt(i)) {
            i++;
        }
        return first.substring(0, i);
    }
}
