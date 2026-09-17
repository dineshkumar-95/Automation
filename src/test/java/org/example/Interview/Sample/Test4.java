package org.example.Interview.Sample;

import java.util.HashSet;
import java.util.Set;

public class Test4 {

    public static void main(String[] args) {
        String str = "abcdabceade";
        System.out.println("Sliding window + Map (best): " + lengthOfLongestSubstringUsingSet(str));

//        System.out.println("Sliding window + Map (best): " + lengthOfLongestSubstringUsingMap(str));
    }

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
                Set.remove(str.charAt(i));
                left++;
            }
            Set.add(c);
            maxLen = Math.max(maxLen, i - left + 1);
        }
        return maxLen;
    }


}

