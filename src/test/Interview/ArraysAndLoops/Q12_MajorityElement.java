package org.example.Interview.ArraysAndLoops;

import java.util.HashMap;
import java.util.Map;

/**
 * Majority Element (Boyer-Moore Voting Algorithm): Find the element that appears
 * more than floor(n / 2) times.
 * SDET: Analyzing distributed logs to detect the most frequent error code.
 */
public class Q12_MajorityElement {
    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        System.out.println("Boyer-Moore (best): " + majorityBoyerMoore(arr));
        System.out.println("HashMap: " + majorityHashMap(arr));
        System.out.println("Sorting: " + majoritySorting(arr.clone()));
    }

    // Best: Boyer-Moore — O(n) time, O(1) space
    public static int majorityBoyerMoore(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("array empty");
        }
        int candidate = nums[0];
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

    // HashMap frequency — O(n) time, O(n) space
    public static int majorityHashMap(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("array empty");
        }
        Map<Integer, Integer> freq = new HashMap<>();
        int majority = nums.length / 2;
        for (int num : nums) {
            int count = freq.getOrDefault(num, 0) + 1;
            if (count > majority) {
                return num;
            }
            freq.put(num, count);
        }
        return nums[0];
    }

    // Sorting: middle element is majority — O(n log n)
    public static int majoritySorting(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("array empty");
        }
        java.util.Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
