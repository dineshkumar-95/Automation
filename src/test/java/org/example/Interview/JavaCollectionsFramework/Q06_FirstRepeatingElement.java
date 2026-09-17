package org.example.Interview.JavaCollectionsFramework;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Find First Repeating Element: Find the first element that repeats (by earliest occurrence).
 * Optimize using a HashSet.
 * SDET: Identifying the first repeated broken element in a serial batch UI render.
 */
public class Q06_FirstRepeatingElement {
    public static void main(String[] args) {
        int[] arr = {10, 5, 3, 4, 3, 5, 6};
        System.out.println("Right-to-left HashSet (best): " + firstRepeatingRightToLeft(arr));
        System.out.println("HashMap index: " + firstRepeatingUsingMap(arr));
        System.out.println("Nested loops: " + firstRepeatingNested(arr));
        System.out.println("List version: " + firstRepeating(List.of(10, 5, 3, 4, 3, 5, 6)));
    }

    // Best: scan right→left, track leftmost repeating index — O(n) time, O(n) space
    public static Integer firstRepeatingRightToLeft(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        Set<Integer> seen = new HashSet<>();
        Integer firstRepeating = null;
        for (int i = arr.length - 1; i >= 0; i--) {
            if (!seen.add(arr[i])) {
                firstRepeating = arr[i];
            }
        }
        return firstRepeating;
    }

    // HashMap of first index + second pass — O(n)
    public static Integer firstRepeatingUsingMap(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        Map<Integer, Integer> firstIndex = new HashMap<>();
        int minIndex = Integer.MAX_VALUE;
        Integer result = null;
        for (int i = 0; i < arr.length; i++) {
            if (firstIndex.containsKey(arr[i])) {
                int idx = firstIndex.get(arr[i]);
                if (idx < minIndex) {
                    minIndex = idx;
                    result = arr[i];
                }
            } else {
                firstIndex.put(arr[i], i);
            }
        }
        return result;
    }

    // Least optimal: nested loops — O(n^2)
    public static Integer firstRepeatingNested(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j]) {
                    return arr[i];
                }
            }
        }
        return null;
    }

    public static Integer firstRepeating(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return firstRepeatingRightToLeft(list.stream().mapToInt(Integer::intValue).toArray());
    }
}
