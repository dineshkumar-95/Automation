package org.example.Interview.ArraysAndLoops;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Find Duplicates: Identify duplicate elements in an array using nested loops,
 * sorting, and HashSet.
 */
public class Q01_FindDuplicates {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 3,1,1, 4, 1, 5};
        String[] sArr = {"aee", "bee","e","qee","qee","qrr","Qdd","Qdd"};
        System.out.println("HashSet (Number): " + findDuplicatesUsingHashSet(arr));
        System.out.println("HashSet (String): " + findDuplicatesUsingHashSet(sArr));
//        System.out.println("Sorting: " + findDuplicatesUsingSorting(arr.clone()));
//        System.out.println("Nested loops: " + findDuplicatesUsingNestedLoops(arr));
        System.out.println("Nested loops: " + findDuplicatesUsingNestedLoops(arr));
    }

    // Best: O(n) time, O(n) space
    public static Set<Integer> findDuplicatesUsingHashSet(int[] arr) {
//        List<Integer> duplicates = new ArrayList<>();
        Set<Integer> seenSet = new HashSet<>();
        Set<Integer> addedSet = new HashSet<>();
        if (arr == null) {
            return addedSet;
        }

        for (int num : arr) {
            if (!seenSet.add(num)) {
                addedSet.add(num);
            }
        }
        return addedSet;
    }

    public static Set<String> findDuplicatesUsingHashSet(String[] arr) {
//        List<Integer> duplicates = new ArrayList<>();
        Set<String> seenSet = new HashSet<>();
        Set<String> addedSet = new HashSet<>();
        if (arr == null) {
            return addedSet;
        }

        for (String str : arr) {
            if (!seenSet.add(str)) {
                addedSet.add(str);
            }
        }
        return addedSet;
    }

    // Sorting: O(n log n) time, O(1) extra if in-place sort OK
    public static List<Integer> findDuplicatesUsingSorting(int[] arr) {
        List<Integer> duplicates = new ArrayList<>();
        if (arr == null || arr.length == 0) {
            return duplicates;
        }
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1] && (duplicates.isEmpty() || duplicates.get(duplicates.size() - 1) != arr[i])) {
                duplicates.add(arr[i]);
            }
        }
        return duplicates;
    }

    // Least optimal: nested loops — O(n^2) time, O(1) space
    public static Set<Integer> findDuplicatesUsingNestedLoops(int[] arr) {
        Set<Integer> duplicates = new HashSet<>();
        if (arr == null || arr.length == 0) {
            return duplicates;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    duplicates.add(arr[i]);
                    break;
                }
            }
        }
        return duplicates;
    }
}
