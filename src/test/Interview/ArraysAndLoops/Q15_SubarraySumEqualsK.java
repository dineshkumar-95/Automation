package org.example.Interview.ArraysAndLoops;

import java.util.HashMap;
import java.util.Map;

/**
 * Subarray Sum Equals K: Find the total number of continuous subarrays whose sum equals k.
 * Optimize using a prefix sum mapping approach.
 * SDET: Validating API batch payloads or transaction ledger blocks matching a target balance.
 */
public class Q15_SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1};
        int k = 2;
        System.out.println("Prefix sum map (best): " + subarraySumPrefixMap(arr, k));
        System.out.println("Cumulative + nested: " + subarraySumNested(arr, k));
        System.out.println("Brute force: " + subarraySumBruteForce(arr, k));
    }

    // Best: prefix sum + HashMap — O(n) time, O(n) space
    public static int subarraySumPrefixMap(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Map<Integer, Integer> prefixCount = new HashMap<>();
        prefixCount.put(0, 1);
        int sum = 0;
        int count = 0;
        for (int num : nums) {
            sum += num;
            count += prefixCount.getOrDefault(sum - k, 0);
            prefixCount.put(sum, prefixCount.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    // Nested with running sum — O(n^2) time, O(1) space
    public static int subarraySumNested(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    // Least optimal: recompute sum each time — O(n^3)
    public static int subarraySumBruteForce(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = 0;
                for (int t = i; t <= j; t++) {
                    sum += nums[t];
                }
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
