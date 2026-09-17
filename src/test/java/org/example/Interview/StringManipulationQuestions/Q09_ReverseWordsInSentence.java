package org.example.Interview.StringManipulationQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Reverse Words in a Sentence: Reverse the order of words, handling multiple spaces
 * and removing leading/trailing spaces. Example: "  hello world  " → "world hello".
 * SDET: Verifying localization and text layout rendering in UI automation.
 */
public class Q09_ReverseWordsInSentence {
    public static void main(String[] args) {
        String str = "  hello world  ";
        System.out.println("Two-pointer (best): '" + reverseWordsTwoPointer(str) + "'");
        System.out.println("Split + StringBuilder: '" + reverseWordsUsingSplit(str) + "'");
        System.out.println("Collections.reverse: '" + reverseWordsUsingList(str) + "'");
    }

    // Best: trim + walk from end, skip spaces — O(n) time, O(n) space
    public static String reverseWordsTwoPointer(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        str = str.trim();
        if (str.isEmpty()) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        int end = str.length() - 1;
        while (end >= 0) {
            while (end >= 0 && str.charAt(end) == ' ') {
                end--;
            }
            int start = end;
            while (start >= 0 && str.charAt(start) != ' ') {
                start--;
            }
            result.append(str, start + 1, end + 1).append(' ');
            end = start;
        }
        if (result.length() > 0) {
            result.setLength(result.length() - 1);
        }
        return result.toString();
    }

    // Split on whitespace then rebuild — O(n) time
    public static String reverseWordsUsingSplit(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        String[] words = str.trim().split("\\s+");
        if (words.length == 0 || (words.length == 1 && words[0].isEmpty())) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            if (i > 0) {
                result.append(' ');
            }
        }
        return result.toString();
    }

    // Least elegant: collect words then Collections.reverse
    public static String reverseWordsUsingList(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        String[] words = str.trim().split("\\s+");
        if (words.length == 0 || (words.length == 1 && words[0].isEmpty())) {
            return "";
        }
        List<String> list = new ArrayList<>();
        Collections.addAll(list, words);
        Collections.reverse(list);
        return String.join(" ", list);
    }
}
