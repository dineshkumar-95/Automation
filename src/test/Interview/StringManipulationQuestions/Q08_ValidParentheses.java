package org.example.Interview.StringManipulationQuestions;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * Valid Parentheses (Bracket Matching): Given a string containing '(', ')', '{', '}',
 * '[' and ']', determine if brackets close in the correct order.
 * SDET: Parsing and validating JSON/XML API responses or config files before test execution.
 */
public class Q08_ValidParentheses {
    public static void main(String[] args) {
        String str = "{[()]}";
        System.out.println("Deque (best): " + isValidUsingDeque(str));
        System.out.println("Stack: " + isValidUsingStack(str));
        System.out.println("Replace loop: " + isValidUsingReplace(str));
    }

    // Best: ArrayDeque as stack — O(n) time, O(n) space
    public static boolean isValidUsingDeque(String str) {
        if (str == null || str.length() % 2 != 0) {
            return false;
        }
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : str.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty() || !isMatching(stack.pop(), c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    // Classic Stack — same complexity, slightly heavier object
    public static boolean isValidUsingStack(String str) {
        if (str == null || str.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty() || !isMatching(stack.pop(), c)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    // Least optimal: repeatedly replace matching pairs — O(n^2) time
    public static boolean isValidUsingReplace(String str) {
        if (str == null) {
            return false;
        }
        String prev;
        do {
            prev = str;
            str = str.replace("()", "").replace("{}", "").replace("[]", "");
        } while (!str.equals(prev));
        return str.isEmpty();
    }

    private static boolean isMatching(char open, char close) {
        return (open == '(' && close == ')')
                || (open == '{' && close == '}')
                || (open == '[' && close == ']');
    }
}
