package org.example.Interview.ArraysAndLoops;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Intersection of Two Arrays: Compute intersection. Unique result, or retain duplicates
 * based on requirements (multiset intersection).
 * SDET: Comparing backend query results vs frontend UI table items for sync verification.
 */
public class Q10_IntersectionOfTwoArrays {
    public static void main(String[] args) {
        int[] a = {1, 2, 2, 1};
        int[] b = {2, 2};
        System.out.println("Unique (Set): " + Arrays.toString(intersectionUnique(a, b)));
        System.out.println("With duplicates (Map): " + Arrays.toString(intersectionWithDuplicates(a, b)));
        System.out.println("Brute force unique: " + Arrays.toString(intersectionBruteForce(a, b)));
    }

    // Best for unique: HashSet — O(m + n) time
    public static int[] intersectionUnique(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[0];
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        Set<Integer> result = new HashSet<>();
        for (int num : nums2) {
            if (set.contains(num)) {
                result.add(num);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    // Retain duplicates by min frequency — O(m + n) time
    public static int[] intersectionWithDuplicates(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[0];
        }
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums1) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        List<Integer> result = new ArrayList<>();
        for (int num : nums2) {
            if (freq.getOrDefault(num, 0) > 0) {
                result.add(num);
                freq.put(num, freq.get(num) - 1);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    // Least optimal unique: nested loops — O(m * n)
    public static int[] intersectionBruteForce(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return new int[0];
        }
        Set<Integer> result = new HashSet<>();
        for (int x : nums1) {
            for (int y : nums2) {
                if (x == y) {
                    result.add(x);
                    break;
                }
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
