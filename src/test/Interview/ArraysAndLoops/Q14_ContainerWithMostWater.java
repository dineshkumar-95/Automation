package org.example.Interview.ArraysAndLoops;

/**
 * Container With Most Water: Given heights of vertical lines, find two lines that
 * with the x-axis form a container holding the most water.
 * SDET: Chart validation or automated testing of data visualization components.
 */
public class Q14_ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Two-pointer (best): " + maxAreaTwoPointer(height));
        System.out.println("Brute force: " + maxAreaBruteForce(height));
    }

    // Best: two pointers from ends — O(n) time, O(1) space
    public static int maxAreaTwoPointer(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int h = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, h * (right - left));
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }

    // Least optimal: try every pair — O(n^2)
    public static int maxAreaBruteForce(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int maxArea = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = Math.min(height[i], height[j]) * (j - i);
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }
}
