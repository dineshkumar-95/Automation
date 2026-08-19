package org.example.Interview.AutomationAndLogicalScenarios;

/**
 * Sub-String Verification: Check if a target string contains a specific sequence
 * of characters (mimicking a test assertion).
 */
public class Q03_SubStringVerification {
    public static void main(String[] args) {
        String actual = "Welcome to the Dashboard - User: admin";
        String expected = "Dashboard";

        System.out.println("contains (best for assertion): " + assertContains(actual, expected));
        System.out.println("indexOf: " + containsUsingIndexOf(actual, expected));
        System.out.println("matches regex: " + containsUsingRegex(actual, expected));
        System.out.println("Manual scan: " + containsManual(actual, expected));
        assertContainsOrThrow(actual, expected);
        System.out.println("Assertion passed for '" + expected + "'");
    }

    // Best for test-style checks: String.contains
    public static boolean assertContains(String actual, String expectedSubstring) {
        if (actual == null || expectedSubstring == null) {
            return false;
        }
        return actual.contains(expectedSubstring);
    }

    // Fail like a soft/hard assertion helper
    public static void assertContainsOrThrow(String actual, String expectedSubstring) {
        if (!assertContains(actual, expectedSubstring)) {
            throw new AssertionError(
                    "Expected text to contain '" + expectedSubstring + "' but was: '" + actual + "'");
        }
    }

    public static boolean containsUsingIndexOf(String actual, String expectedSubstring) {
        if (actual == null || expectedSubstring == null) {
            return false;
        }
        return actual.indexOf(expectedSubstring) >= 0;
    }

    public static boolean containsUsingRegex(String actual, String expectedSubstring) {
        if (actual == null || expectedSubstring == null) {
            return false;
        }
        return actual.matches("(?s).*" + java.util.regex.Pattern.quote(expectedSubstring) + ".*");
    }

    // Least preferred: manual character matching
    public static boolean containsManual(String actual, String expectedSubstring) {
        if (actual == null || expectedSubstring == null) {
            return false;
        }
        if (expectedSubstring.isEmpty()) {
            return true;
        }
        outer:
        for (int i = 0; i <= actual.length() - expectedSubstring.length(); i++) {
            for (int j = 0; j < expectedSubstring.length(); j++) {
                if (actual.charAt(i + j) != expectedSubstring.charAt(j)) {
                    continue outer;
                }
            }
            return true;
        }
        return false;
    }
}
