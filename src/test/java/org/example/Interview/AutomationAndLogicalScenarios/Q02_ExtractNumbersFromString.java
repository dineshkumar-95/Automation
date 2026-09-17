package org.example.Interview.AutomationAndLogicalScenarios;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Extract Numbers from String: Use Regular Expressions (Regex) to extract only
 * the numeric digits from an alphanumeric test string.
 */
public class Q02_ExtractNumbersFromString {
    public static void main(String[] args) {
        String input = "Order #A12B-345 costs $67.89 on 2024";
        System.out.println("All digit groups (regex best): " + extractNumberGroups(input));
        System.out.println("Digits only concatenated: " + extractDigitsOnly(input));
        System.out.println("Loop Character.isDigit: " + extractDigitsUsingLoop(input));
        System.out.println("As integers: " + extractAsIntegers(input));
    }

    // Best for "numbers" as tokens: regex find all digit sequences
    public static List<String> extractNumberGroups(String input) {
        List<String> numbers = new ArrayList<>();
        if (input == null || input.isEmpty()) {
            return numbers;
        }
        Matcher matcher = Pattern.compile("\\d+").matcher(input);
        while (matcher.find()) {
            numbers.add(matcher.group());
        }
        return numbers;
    }

    // Keep only digits as one string — replaceAll non-digits
    public static String extractDigitsOnly(String input) {
        if (input == null) {
            return "";
        }
        return input.replaceAll("\\D+", "");
    }

    // Without regex: Character.isDigit
    public static String extractDigitsUsingLoop(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    // Parse each digit group to int
    public static List<Integer> extractAsIntegers(String input) {
        List<Integer> numbers = new ArrayList<>();
        for (String group : extractNumberGroups(input)) {
            numbers.add(Integer.parseInt(group));
        }
        return numbers;
    }
}
