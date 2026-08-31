package org.example.Interview.StringManipulationQuestions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * String Tokenization and Regex Masking: From a raw text block (e.g. a log line),
 * extract sensitive patterns like emails, credit cards, or phone numbers using Regex
 * and replace them with [MASKED].
 * SDET: Cleaning test reports or console logs for GDPR/PII compliance.
 */
public class Q14_StringTokenizationRegexMasking {
    private static final Pattern EMAIL = Pattern.compile(
            "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
    private static final Pattern PHONE = Pattern.compile(
            "\\b(?:\\+?\\d{1,3}[-.\\s]?)?(?:\\(?\\d{3}\\)?[-.\\s]?)\\d{3}[-.\\s]?\\d{4}\\b");
    private static final Pattern CREDIT_CARD = Pattern.compile(
            "\\b(?:\\d[ -]*?){13,19}\\b");

    public static void main(String[] args) {
        String log = "User john.doe@mail.com paid with 4111-1111-1111-1111, call +1 555-123-4567";
        System.out.println("Combined mask (best): " + maskSensitiveData(log));
        System.out.println("Step by step: " + maskStepByStep(log));
        System.out.println("Tokenize words: " + tokenize(log));
    }

    // Best: single pass with combined pattern — O(n) relative to input length
    public static String maskSensitiveData(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }
        Pattern combined = Pattern.compile(
                EMAIL.pattern() + "|" + CREDIT_CARD.pattern() + "|" + PHONE.pattern());
        return combined.matcher(text).replaceAll("[MASKED]");
    }

    // Apply each pattern sequentially
    public static String maskStepByStep(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }
        text = EMAIL.matcher(text).replaceAll("[MASKED]");
        text = CREDIT_CARD.matcher(text).replaceAll("[MASKED]");
        text = PHONE.matcher(text).replaceAll("[MASKED]");
        return text;
    }

    // Tokenize into words (simple split) — useful for further inspection
    public static java.util.List<String> tokenize(String text) {
        java.util.List<String> tokens = new java.util.ArrayList<>();
        if (text == null || text.isEmpty()) {
            return tokens;
        }
        Matcher matcher = Pattern.compile("\\S+").matcher(text);
        while (matcher.find()) {
            tokens.add(matcher.group());
        }
        return tokens;
    }
}
