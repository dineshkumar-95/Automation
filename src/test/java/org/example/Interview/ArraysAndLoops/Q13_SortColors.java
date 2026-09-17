package org.example.Interview.ArraysAndLoops;

import java.util.Arrays;

/**
 * Sort an Array of 0s, 1s, and 2s (Dutch National Flag): Sort in-place in a single pass
 * without using standard library sort.
 * SDET: Triaging automation results into PASS, FAIL, and SKIP buckets.
 */
public class Q13_SortColors {
    public static void main(String[] args) {
        int[] a = {2, 0, 2, 1, 1, 0};
        sortDutchNationalFlag(a);
        System.out.println("Dutch National Flag (best): " + Arrays.toString(a));

        int[] b = {2, 0, 2, 1, 1, 0};
        sortCounting(b);
        System.out.println("Counting: " + Arrays.toString(b));

        int[] c = {2, 0, 2, 1, 1, 0};
        sortNested(c);
        System.out.println("Nested swaps: " + Arrays.toString(c));
    }

    // Best: three-way partition — O(n) time, O(1) space, one pass
    public static void sortDutchNationalFlag(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int low = 0, mid = 0, high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    // Counting sort style — O(n) time, two passes
    public static void sortCounting(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int zeros = 0, ones = 0, twos = 0;
        for (int num : nums) {
            if (num == 0) {
                zeros++;
            } else if (num == 1) {
                ones++;
            } else {
                twos++;
            }
        }
        int i = 0;
        while (zeros-- > 0) {
            nums[i++] = 0;
        }
        while (ones-- > 0) {
            nums[i++] = 1;
        }
        while (twos-- > 0) {
            nums[i++] = 2;
        }
    }

    // Least optimal: bubble-style nested — O(n^2)
    public static void sortNested(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    swap(nums, i, j);
                }
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
