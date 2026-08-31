package org.example.Interview.JavaCollectionsFramework;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * ArrayList vs. LinkedList: Demonstrate the performance difference in data insertion
 * between both lists (end insert vs middle insert).
 */
public class Q02_ArrayListVsLinkedList {
    private static final int N = 50_000;

    public static void main(String[] args) {
        System.out.println("--- Insert at END ---");
        System.out.println("ArrayList end (usually faster): " + insertAtEnd(new ArrayList<>()) + " ms");
        System.out.println("LinkedList end: " + insertAtEnd(new LinkedList<>()) + " ms");

        System.out.println("--- Insert at BEGINNING ---");
        System.out.println("ArrayList beginning (slow - shifts): " + insertAtBeginning(new ArrayList<>()) + " ms");
        System.out.println("LinkedList beginning (faster): " + insertAtBeginning(new LinkedList<>()) + " ms");

        System.out.println("--- Insert at MIDDLE ---");
        System.out.println("ArrayList middle: " + insertAtMiddle(new ArrayList<>()) + " ms");
        System.out.println("LinkedList middle (still costly due to traversal): " + insertAtMiddle(new LinkedList<>()) + " ms");

        System.out.println("--- Random access ---");
        System.out.println("ArrayList get (best): " + randomAccess(new ArrayList<>()) + " ms");
        System.out.println("LinkedList get (slow): " + randomAccess(new LinkedList<>()) + " ms");
    }

    // ArrayList usually wins: amortized O(1) append
    public static long insertAtEnd(List<Integer> list) {
        long start = System.nanoTime();
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        return (System.nanoTime() - start) / 1_000_000;
    }

    // LinkedList wins: O(1) addFirst; ArrayList is O(n) per insert
    public static long insertAtBeginning(List<Integer> list) {
        long start = System.nanoTime();
        for (int i = 0; i < N; i++) {
            list.add(0, i);
        }
        return (System.nanoTime() - start) / 1_000_000;
    }

    // Both costly; LinkedList pays for index traversal
    public static long insertAtMiddle(List<Integer> list) {
        long start = System.nanoTime();
        for (int i = 0; i < N / 10; i++) {
            list.add(list.size() / 2, i);
        }
        return (System.nanoTime() - start) / 1_000_000;
    }

    // ArrayList O(1) get; LinkedList O(n) get
    public static long randomAccess(List<Integer> list) {
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        long start = System.nanoTime();
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += list.get(i);
        }
        // prevent dead-code elimination of unused sum
        if (sum == Integer.MIN_VALUE) {
            System.out.print("");
        }
        return (System.nanoTime() - start) / 1_000_000;
    }
}
