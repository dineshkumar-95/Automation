package org.example.Interview.ArraysAndLoops;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Two Sum Problem: Find all pairs of integers in an array whose sum equals a specified target.
 */
public class Q04_TwoSum {
    public static void main(String[] args) {
//        int[] arr = {2, 7, 11, 15, 3, 6};
        int[] arr = {2, 2,7, 11, 7,15,6,3,2};
        int target = 9;
        System.out.println("HashMap (best): " + formatPairs(findPairsUsingHashMap(arr, target)));
        System.out.println("Sorting two-pointer: " + formatPairs(findPairsUsingTwoPointer(arr.clone(), target)));
        System.out.println("Nested loops: " + formatPairs(findPairsUsingNestedLoops(arr, target)));
        System.out.println("Nested loops: " + formatPairs(findPairsUsingHashMap2(arr, target)));
    }

    private static String formatPairs(List<int[]> pairs) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < pairs.size(); i++) {
            sb.append(Arrays.toString(pairs.get(i)));
            if (i < pairs.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.append("]").toString();
    }

    // Best: HashMap complement lookup — O(n) time, O(n) space
    public static List<int[]> findPairsUsingHashMap(int[] arr, int target) {
        List<int[]> pairs = new ArrayList<>();
        if (arr == null || arr.length < 2) {
            return pairs;
        }
        Map<Integer, Integer> seen = new HashMap<>();
        Set<String> unique = new HashSet<>();
        for (int num : arr) {
            int complement = target - num;
            if (seen.containsKey(complement)) {
                int a = Math.min(num, complement);
                int b = Math.max(num, complement);
                String key = a + ":" + b;
                if (unique.add(key)) {
                    pairs.add(new int[]{a, b});
                }
            }
            seen.put(num, seen.getOrDefault(num, 0) + 1);
        }
        return pairs;
    }

    // Sorting + two pointers — O(n log n) time
    public static List<int[]> findPairsUsingTwoPointer(int[] arr, int target) {
        List<int[]> pairs = new ArrayList<>();
        if (arr == null || arr.length < 2) {
            return pairs;
        }
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (sum == target) {
                pairs.add(new int[]{arr[left], arr[right]});
                int leftVal = arr[left];
                int rightVal = arr[right];
                while (left < right && arr[left] == leftVal) {
                    left++;
                }
                while (left < right && arr[right] == rightVal) {
                    right--;
                }
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return pairs;
    }

    // Least optimal: nested loops — O(n^2) time
    public static List<int[]> findPairsUsingNestedLoops(int[] arr, int target) {
        List<int[]> pairs = new ArrayList<>();
        if (arr == null || arr.length < 2) {
            return pairs;
        }
        Set<String> unique = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == target) {
                    int a = Math.min(arr[i], arr[j]);
                    int b = Math.max(arr[i], arr[j]);
                    if (unique.add(a + ":" + b)) {
                        pairs.add(new int[]{a, b});
                    }
                }
            }
        }
        return pairs;
    }

    public static List<int[]> findPairsUsingHashMap2(int[] arr, int target) {
        List<int[]> pairs = new ArrayList<>();
        if (arr == null || arr.length < 2) {
            return pairs;
        }
        // Tracks elements we have seen and their remaining "available" counts
        Map<Integer, Integer> counts = new HashMap<>();

        for (int num : arr) {
            int complement = target - num;
            // Check if we have an available complement to match with this number
            if (counts.getOrDefault(complement, 0) > 0) {
                pairs.add(new int[]{Math.min(num, complement), Math.max(num, complement)});
                // Consume the complement so we don't reuse it for the same exact pair
                counts.put(complement, counts.get(complement) - 1);
            } else {
                // If no complement is ready right now, save this number for future pairs
                counts.put(num, counts.getOrDefault(num, 0) + 1);
            }
        }
        return pairs;

    }

}
