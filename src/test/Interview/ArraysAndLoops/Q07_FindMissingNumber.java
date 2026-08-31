package org.example.Interview.ArraysAndLoops;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Find the Missing Number: Array contains n distinct numbers from 0..n; find the missing one.
 * Optimize to O(n) time and O(1) space.
 * SDET: Audit that serial/sequence IDs from backend are continuous without gaps.
 */
public class Q07_FindMissingNumber {
    public static void main(String[] args) {
        int[] arr = {3, 0, 1,4,5,2,7,10};
        System.out.println("XOR (best): " + missingNumberXor(arr));
        System.out.println("Sum formula: " + missingNumberSum(arr));
        System.out.println("HashSet: " + missingNumberHashSet(arr));
    }

    // Best: XOR all indices and values — O(n) time, O(1) space
    public static int missingNumberXor(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }

    // Gauss formula — O(n) time, O(1) space (watch overflow; use long)
    public static int missingNumberSum(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int n = nums.length;
        long expected = (long) n * (n + 1) / 2;
        long actual = 0;
        for (int num : nums) {
            actual += num;
        }
        return (int) (expected - actual);
    }

    // HashSet — O(n) time, O(n) space
    public static List<Integer> missingNumberHashSet(int[] nums) {
        if (nums == null) {
            return null;
        }
        List<Integer> missingNumber = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        int max = 0;
        for (int num : nums) {
            set.add(num);
            max = Math.max(max,num);
        }
        for (int i = 0; i <= max; i++) {
            if (set.contains(i)) {
                missingNumber.add(i);
            }
        }
        return missingNumber;
    }
}
