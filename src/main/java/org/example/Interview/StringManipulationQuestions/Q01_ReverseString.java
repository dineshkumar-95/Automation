package org.example.Interview.StringManipulationQuestions;

/**
 * Reverse String: Reverse the characters of a given string.
 */
public class Q01_ReverseString {
    public static void main(String[] args) {
        String original = "Testing";
        System.out.println("Two-pointer (best): " + reverseStringTwoPointer(original));
        System.out.println("Loop: " + reverseStringUsingLoop(original));
        System.out.println("StringBuilder: " + reverseStringUsingStringBuilder(original));
        System.out.println("StringBuffer: " + reverseStringUsingStringBuffer(original));
        System.out.println("Recursion: " + reverseStringUsingRecursion(original));
    }

    // Best: O(n) time, O(1) extra space (in-place swap on char array)
    public static String reverseStringTwoPointer(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        char[] chars = str.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }

    public static String reverseStringTwoPointer2(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        char[] chars = str.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }


    // O(n) time, O(n) space — build new array from end to start
    public static String reverseStringUsingLoop(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        int len = str.length();
        char[] orig = str.toCharArray();
        char[] reversed = new char[len];
        for (int i = 0; i < len; i++) {
            reversed[i] = orig[len - 1 - i];
        }
        return new String(reversed);
    }

    // Built-in reverse — simple, O(n) space
    public static String reverseStringUsingStringBuilder(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        return new StringBuilder(str).reverse().toString();
    }

    // Same idea as StringBuilder, but synchronized (unnecessary here)
    public static String reverseStringUsingStringBuffer(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        return new StringBuffer(str).reverse().toString();
    }

    // Least optimal: O(n) time, O(n) stack space — risk of StackOverflow for long strings
    public static String reverseStringUsingRecursion(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        return reverseStringUsingRecursion(str.substring(1)) + str.charAt(0);
    }
}
