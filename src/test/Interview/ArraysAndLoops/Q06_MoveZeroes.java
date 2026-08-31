package org.example.Interview.ArraysAndLoops;

import java.util.Arrays;

/**
 * Move Zeroes to the End: Move all 0s to the end while maintaining relative order
 * of non-zero elements. Must be in-place without copying the array.
 * SDET: Sorting UI lists where inactive/empty rows are pushed to the bottom of a table.
 */
public class Q06_MoveZeroes {
    public static void main(String[] args) {
        int[] a = {0, 1, 0, 3, 12};
        moveZeroesTwoPointer(a);
        System.out.println("Two-pointer (best): " + Arrays.toString(a));

        int[] b = {0, 1, 0, 3, 12};
        moveZeroesSnowball(b);
        System.out.println("Snowball: " + Arrays.toString(b));

        int[] c = {0, 1, 0, 3, 12};
        moveZeroesBruteForce(c);
        System.out.println("Brute force: " + Arrays.toString(c));
    }

    // Best: two-pointer overwrite — O(n) time, O(1) space
    public static void moveZeroesTwoPointer(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int write = 0;
        for (int read = 0; read < nums.length; read++) {
            if (nums[read] != 0) {
                nums[write] = nums[read];
                write++;
            }
        }
        while (write < nums.length) {
            nums[write] = 0;
            write++;
        }
    }

    // Swap non-zeros forward (snowball of zeros) — O(n) time, O(1) space
    public static void moveZeroesSnowball(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int snowball = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                snowball++;
            } else if (snowball > 0) {
                nums[i - snowball] = nums[i];
                nums[i] = 0;
            }
        }
    }

    // Least optimal: shift on each zero — O(n^2) time
    public static void moveZeroesBruteForce(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        nums[i] = nums[j];
                        nums[j] = 0;
                        break;
                    }
                }
            }
        }
    }
}
