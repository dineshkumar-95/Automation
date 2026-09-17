package org.example.Interview.ArraysAndLoops;

import java.util.Arrays;

/**
 * Remove Element: Remove all instances of a specific value from an array in-place
 * and return the new length.
 */
public class Q05_RemoveElement {
    public static void main(String[] args) {
        int[] arr1 = {3, 2, 2, 3, 4, 3};
        int len1 = removeElementTwoPointer(arr1, 3);
        System.out.println("Two-pointer (best): length=" + len1 + ", arr=" + Arrays.toString(Arrays.copyOf(arr1, len1)));

        int[] arr2 = {3, 2, 2, 3, 4, 3};
        int len2 = removeElementCopyForward(arr2, 3);
        System.out.println("Copy forward: length=" + len2 + ", arr=" + Arrays.toString(Arrays.copyOf(arr2, len2)));

        int[] arr3 = {3, 2, 2, 3, 4, 3};
        int len3 = removeElementUsingList(arr3, 3);
        System.out.println("List filter: length=" + len3);
    }

    // Best: two-pointer overwrite — O(n) time, O(1) space
    public static int removeElementTwoPointer(int[] arr, int val) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int write = 0;
        for (int read = 0; read < arr.length; read++) {
            if (arr[read] != val) {
                arr[write++] = arr[read];
            }
        }
        return write;
    }

    // Same idea, swap-from-end style when removals are rare — O(n) time, O(1) space
    public static int removeElementCopyForward(int[] arr, int val) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int i = 0;
        int n = arr.length;
        while (i < n) {
            if (arr[i] == val) {
                arr[i] = arr[n - 1];
                n--;
            } else {
                i++;
            }
        }
        return n;
    }

    // Least preferred for "in-place": filter via list then copy back — O(n) space
    public static int removeElementUsingList(int[] arr, int val) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        java.util.List<Integer> kept = new java.util.ArrayList<>();
        for (int num : arr) {
            if (num != val) {
                kept.add(num);
            }
        }
        for (int i = 0; i < kept.size(); i++) {
            arr[i] = kept.get(i);
        }
        return kept.size();
    }
}
