package org.example.Interview.AutomationAndLogicalScenarios;

import java.security.SecureRandom;
import java.util.Random;

/**
 * Generate Random Test Data with Constraints: Alphanumeric string of length N that
 * starts with uppercase, ends with special char, and contains at least two digits.
 * SDET: Data-driven registration, password complexity, or coupon code validation.
 */
public class Q08_GenerateRandomTestData {
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL = "!@#$%^&*";
    private static final String MIDDLE = UPPER + LOWER + DIGITS;
    private static final Random RANDOM = new SecureRandom();

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            String value = generate(12);
            System.out.println(value + " -> valid=" + isValid(value));
        }
    }

    // Best: build with guaranteed constraints, then fill remaining — O(n)
    public static String generate(int n) {
        if (n < 4) {
            throw new IllegalArgumentException("length must be >= 4 to satisfy constraints");
        }
        char[] chars = new char[n];
        chars[0] = UPPER.charAt(RANDOM.nextInt(UPPER.length()));
        chars[n - 1] = SPECIAL.charAt(RANDOM.nextInt(SPECIAL.length()));

        // Place two required digits in middle slots
        int d1 = 1 + RANDOM.nextInt(n - 2);
        int d2;
        do {
            d2 = 1 + RANDOM.nextInt(n - 2);
        } while (d2 == d1);
        chars[d1] = DIGITS.charAt(RANDOM.nextInt(DIGITS.length()));
        chars[d2] = DIGITS.charAt(RANDOM.nextInt(DIGITS.length()));

        for (int i = 1; i < n - 1; i++) {
            if (chars[i] == 0) {
                chars[i] = MIDDLE.charAt(RANDOM.nextInt(MIDDLE.length()));
            }
        }
        return new String(chars);
    }

    // Reject/retry until valid (simple but less efficient)
    public static String generateByRetry(int n) {
        if (n < 4) {
            throw new IllegalArgumentException("length must be >= 4");
        }
        String pool = MIDDLE + SPECIAL;
        for (int attempt = 0; attempt < 10_000; attempt++) {
            StringBuilder sb = new StringBuilder(n);
            sb.append(UPPER.charAt(RANDOM.nextInt(UPPER.length())));
            for (int i = 1; i < n - 1; i++) {
                sb.append(pool.charAt(RANDOM.nextInt(pool.length())));
            }
            sb.append(SPECIAL.charAt(RANDOM.nextInt(SPECIAL.length())));
            String candidate = sb.toString();
            if (isValid(candidate)) {
                return candidate;
            }
        }
        throw new IllegalStateException("failed to generate valid string");
    }

    public static boolean isValid(String value) {
        if (value == null || value.length() < 4) {
            return false;
        }
        if (!Character.isUpperCase(value.charAt(0))) {
            return false;
        }
        if (SPECIAL.indexOf(value.charAt(value.length() - 1)) < 0) {
            return false;
        }
        int digits = 0;
        for (int i = 0; i < value.length(); i++) {
            if (Character.isDigit(value.charAt(i))) {
                digits++;
            }
        }
        return digits >= 2;
    }
}
