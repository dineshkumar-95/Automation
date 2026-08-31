package org.example.Interview.StringManipulationQuestions;

/**
 * Check if Two Strings are Rotation of Each Other: Given s1 and s2, check if s2 is a
 * rotated version of s1 (e.g., "amazon" and "onamaz"). Hint: s2 is a substring of (s1 + s1).
 * SDET: Testing carousel UI components or infinite scroll loops.
 */
public class Q13_StringRotation {
    public static void main(String[] args) {
        String s1 = "amazon";
        String s2 = "onamaz";
        System.out.println("Concat + contains (best): " + isRotationUsingConcat(s1, s2));
        System.out.println("Queue rotation: " + isRotationUsingQueue(s1, s2));
        System.out.println("Brute force rotate: " + isRotationBruteForce(s1, s2));
    }

    // Best: O(n) average with contains — O(n) time, O(n) space
    public static boolean isRotationUsingConcat(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length() || s1.isEmpty()) {
            return false;
        }
        return (s1 + s1).contains(s2);
    }

    // Rotate via queue comparison — O(n^2) time
    public static boolean isRotationUsingQueue(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length() || s1.isEmpty()) {
            return false;
        }
        java.util.Deque<Character> q1 = new java.util.ArrayDeque<>();
        java.util.Deque<Character> q2 = new java.util.ArrayDeque<>();
        for (char c : s1.toCharArray()) {
            q1.addLast(c);
        }
        for (char c : s2.toCharArray()) {
            q2.addLast(c);
        }
        for (int i = 0; i < s1.length(); i++) {
            if (q1.equals(q2)) {
                return true;
            }
            q1.addLast(q1.removeFirst());
        }
        return false;
    }

    // Least optimal: try every rotation via substring — O(n^2) time
    public static boolean isRotationBruteForce(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() != s2.length() || s1.isEmpty()) {
            return false;
        }
        for (int i = 0; i < s1.length(); i++) {
            String rotated = s1.substring(i) + s1.substring(0, i);
            if (rotated.equals(s2)) {
                return true;
            }
        }
        return false;
    }
}
