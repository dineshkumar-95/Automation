package org.example.Interview.ArraysAndLoops;

import java.util.Arrays;

/**
 * Rotate an Array: Rotate an array of n elements to the right by k steps.
 * Example: [1,2,3,4,5,6,7], k=3 → [5,6,7,1,2,3,4].
 * SDET: Validating data pagination loops, UI carousels, or carousel assertions.
 */
public class Q08_RotateArray {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        rotateReverse(a, 3);
        System.out.println("Reverse (best): " + Arrays.toString(a));

        int[] b = {1, 2, 3, 4, 5, 6, 7};
        rotateExtraArray(b, 3);
        System.out.println("Extra array: " + Arrays.toString(b));

        int[] c = {1, 2, 3, 4, 5, 6, 7};
        rotateOneByOne(c, 3);
        System.out.println("One by one: " + Arrays.toString(c));
    }

    // Best: reverse whole, then parts — O(n) time, O(1) space
    public static void rotateReverse(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        k = k % nums.length;
        if (k == 0) {
            return;
        }
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    // Extra array — O(n) time, O(n) space
    public static void rotateExtraArray(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        k = k % nums.length;
        if (k == 0) {
            return;
        }
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[(i + k) % nums.length] = nums[i];
        }
        System.arraycopy(temp, 0, nums, 0, nums.length);
    }

    // Least optimal: rotate one step k times — O(n*k) time
    public static void rotateOneByOne(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        k = k % nums.length;
        for (int r = 0; r < k; r++) {
            int last = nums[nums.length - 1];
            for (int i = nums.length - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = last;
        }
    }

    private static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
