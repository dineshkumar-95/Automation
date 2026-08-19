package org.example.Interview.ArraysAndLoops;

/**
 * Maximum Subarray (Kadane’s Algorithm): Find contiguous subarray with largest sum.
 * SDET: Rate-limiting / network throughput testing to identify peak burst windows.
 */
public class Q11_MaximumSubarray {
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Kadane (best): " + maxSubArrayKadane(arr));
        System.out.println("DP array: " + maxSubArrayDp(arr));
        System.out.println("Brute force: " + maxSubArrayBruteForce(arr));
    }

    // Best: Kadane — O(n) time, O(1) space
    public static int maxSubArrayKadane(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("array empty");
        }
        int maxEndingHere = nums[0];
        int maxSoFar = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }

    // DP with array — O(n) time, O(n) space
    public static int maxSubArrayDp(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("array empty");
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    // Least optimal: all subarrays — O(n^2)
    public static int maxSubArrayBruteForce(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("array empty");
        }
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}
