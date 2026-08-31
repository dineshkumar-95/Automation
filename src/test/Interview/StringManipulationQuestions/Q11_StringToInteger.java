package org.example.Interview.StringManipulationQuestions;

/**
 * Convert String to Integer (atoi): Convert a string into a 32-bit signed integer,
 * discarding leading whitespace and handling optional + or - signs and non-digit characters.
 * SDET: Extracting prices, quantities, or IDs from raw UI text labels for assertions.
 */
public class Q11_StringToInteger {
    public static void main(String[] args) {
        String str = "   -42abc";
        System.out.println("Manual parse (best): " + myAtoi(str));
        System.out.println("Long accumulator: " + myAtoiUsingLong(str));
        System.out.println("Regex + parseInt: " + myAtoiUsingRegex(str));
    }

    // Best: single pass with overflow checks — O(n) time, O(1) space
    public static int myAtoi(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        int i = 0;
        int n = str.length();
        while (i < n && str.charAt(i) == ' ') {
            i++;
        }
        if (i == n) {
            return 0;
        }
        int sign = 1;
        if (str.charAt(i) == '+' || str.charAt(i) == '-') {
            sign = str.charAt(i) == '-' ? -1 : 1;
            i++;
        }
        int result = 0;
        while (i < n && Character.isDigit(str.charAt(i))) {
            int digit = str.charAt(i) - '0';
            if (result > (Integer.MAX_VALUE - digit) / 10) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + digit;
            i++;
        }
        return result * sign;
    }

    // Uses long to detect overflow — slightly simpler checks
    public static int myAtoiUsingLong(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        int i = 0;
        int n = str.length();
        while (i < n && str.charAt(i) == ' ') {
            i++;
        }
        if (i == n) {
            return 0;
        }
        int sign = 1;
        if (str.charAt(i) == '+' || str.charAt(i) == '-') {
            sign = str.charAt(i) == '-' ? -1 : 1;
            i++;
        }
        long result = 0;
        while (i < n && Character.isDigit(str.charAt(i))) {
            result = result * 10 + (str.charAt(i) - '0');
            if (sign == 1 && result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && -result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            i++;
        }
        return (int) (result * sign);
    }

    // Least preferred in interviews: regex then Integer.parseInt
    public static int myAtoiUsingRegex(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        str = str.trim();
        if (str.isEmpty()) {
            return 0;
        }
        java.util.regex.Matcher matcher = java.util.regex.Pattern
                .compile("^[+-]?\\d+")
                .matcher(str);
        if (!matcher.find()) {
            return 0;
        }
        try {
            return Integer.parseInt(matcher.group());
        } catch (NumberFormatException e) {
            return matcher.group().startsWith("-") ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
    }
}
