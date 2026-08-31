package org.example.Interview.StringManipulationQuestions;

/**
 * Palindrome: Check whether a given string or number reads the same forwards and backwards.
 */
public class Q02_Palindrome {
    public static void main(String[] args) {

        // Palindrome String
        String str = "Madam";
        System.out.println("isPalindromeString (two-pointer): " + isPalindromeStringTwoPointer(str));
        System.out.println("isPalindromeString (reverse): " + isPalindromeStringUsingReverse(str));

        // Palindrome Number
        int number = 0;
        System.out.println("isPalindromeNumber (half reverse - best): " + isPalindromeNumberHalfReverse(number));
        System.out.println("isPalindromeNumber (full reverse): " + isPalindromeNumber(number));
        System.out.println("isPalindromeNumber (string): " + isPalindromeNumberUsingString(number));
    }

    // ----- Palindrome String -----

    // Best: O(n) time, O(1) space — early exit on first mismatch
    public static boolean isPalindromeStringTwoPointer(String str) {
        if (str == null) {
            return false;
        }
        int a =123;
        if (str.length() <= 1) {
            return true;
        }
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (Character.toLowerCase(str.charAt(left)) != Character.toLowerCase(str.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Less optimal: O(n) time, O(n) space
    public static boolean isPalindromeStringUsingReverse(String str) {
        if (str == null) {
            return false;
        }
        if (str.length() <= 1) {
            return true;
        }
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equalsIgnoreCase(reversed);
    }

    // ----- Palindrome Number -----

    // Best: reverse only half the digits — avoids overflow, stops early
    // Example: 1221 → reverse half = 12, remaining = 12 → equal → true
    // Example: 12321 → reverse half = 123, remaining = 12 → 123/10 == 12 → true
    public static boolean isPalindromeNumberHalfReverse(int number) {
        if (number < 0 || (number % 10 == 0 && number != 0)) {
            return false; // negatives, and trailing-zero numbers (10, 100...) can't be palindromes
        }
        if (number < 10) {
            return true;
        }
        int reversedHalf = 0;
        while (number > reversedHalf) {
            reversedHalf = reversedHalf * 10 + number % 10;
            number = number / 10;
        }
        // Even digits: number == reversedHalf (1221 → 12 == 12)
        // Odd digits:  ignore middle digit via /10 (12321 → 12 == 123/10)
        return number == reversedHalf || number == reversedHalf / 10;
    }

    // Full reverse: O(d) time, O(1) space — can overflow for very large ints
    public static boolean isPalindromeNumber(int number) {
        if (number < 0) {
            return false;
        }
        int original = number;
        int reversed = 0;
        while (number > 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number = number / 10;
        }
        return original == reversed;
    }

    // Least optimal: convert to string — O(d) extra space
    public static boolean isPalindromeNumberUsingString(int number) {
        if (number < 0) {
            return false;
        }
        String str = String.valueOf(number);
        return isPalindromeStringTwoPointer(str);
    }
}
