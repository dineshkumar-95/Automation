package org.example.Interview.AutomationAndLogicalScenarios;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * FizzBuzz: Print numbers 1 to 100, replacing multiples of 3 with "Fizz",
 * multiples of 5 with "Buzz", and both with "FizzBuzz".
 */
public class Q01_FizzBuzz {
    public static void main(String[] args) {
        System.out.println("If-else (best/clear): " + fizzBuzzIfElse(1, 20));
        System.out.println("String concat: " + fizzBuzzConcat(1, 20));
        System.out.println("Stream: " + fizzBuzzStream(1, 20));
    }

    // Best for interviews: explicit if/else order (check 15 first)
    public static List<String> fizzBuzzIfElse(int start, int end) {
        List<String> result = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            if (i % 15 == 0) {
                result.add("FizzBuzz");
            } else if (i % 3 == 0) {
                result.add("Fizz");
            } else if (i % 5 == 0) {
                result.add("Buzz");
            } else {
                result.add(String.valueOf(i));
            }
        }
        return result;
    }

    // Build label by concatenation — avoids nested 15 check
    public static List<String> fizzBuzzConcat(int start, int end) {
        List<String> result = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            StringBuilder sb = new StringBuilder();
            if (i % 3 == 0) {
                sb.append("Fizz");
            }
            if (i % 5 == 0) {
                sb.append("Buzz");
            }
            result.add(sb.length() == 0 ? String.valueOf(i) : sb.toString());
        }
        return result;
    }

    // Stream version
    public static List<String> fizzBuzzStream(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .mapToObj(i -> {
                    if (i % 15 == 0) {
                        return "FizzBuzz";
                    }
                    if (i % 3 == 0) {
                        return "Fizz";
                    }
                    if (i % 5 == 0) {
                        return "Buzz";
                    }
                    return String.valueOf(i);
                })
                .collect(Collectors.toList());
    }
}
