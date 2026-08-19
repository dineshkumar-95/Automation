package org.example.Interview.ArraysAndLoops;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * Merge Sorted Arrays: Combine two pre-sorted integer arrays into a single, fully sorted array.
 */
public class Q03_MergeSortedArrays {
    public static void main(String[] args) {
        int[] a = {1, 3, 5, 7,9,10,11,12};
        int[] b = {2, 4, 6, 8,13};
        Arrays.stream(b).max();
        System.out.println("Two-pointer (best): " + Arrays.toString(mergeTwoPointer(a, b)));
//        System.out.println("System.arraycopy + sort: " + Arrays.toString(mergeCopyAndSort(a, b)));
//        System.out.println("Nested insert: " + Arrays.toString(mergeNested(a, b)));
        System.out.println("Nested insert: " + mergeTreeSet(a, b));
        System.out.println("Nested insert: " +Arrays.toString(mergeArray(a, b)));
    }

    // Best: two-pointer merge — O(m + n) time, O(m + n) space
    public static int[] mergeTwoPointer(int[] a, int[] b) {
        if (a == null || a.length == 0) {
            return b == null ? new int[0] : b.clone();
        }
        if (b == null || b.length == 0) {
            return a.clone();
        }
        int[] result = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                result[k++] = a[i++];
            } else {
                result[k++] = b[j++];
            }
        }
        while (i < a.length) {
            result[k++] = a[i++];
        }
        while (j < b.length) {
            result[k++] = b[j++];
        }
        return result;
    }

    // Copy then sort — O((m+n) log(m+n))
    public static int[] mergeCopyAndSort(int[] a, int[] b) {
        if (a == null) {
            a = new int[0];
        }
        if (b == null) {
            b = new int[0];
        }
        int[] result = new int[a.length + b.length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        Arrays.sort(result);
        return result;
    }

    // Least optimal: build by inserting each element — O((m+n)^2) worst case
    public static int[] mergeNested(int[] a, int[] b) {
        if (a == null) {
            a = new int[0];
        }
        if (b == null) {
            b = new int[0];
        }
        int[] result = new int[a.length + b.length];
        int size = 0;
        for (int num : a) {
            size = insertSorted(result, size, num);
        }
        for (int num : b) {
            size = insertSorted(result, size, num);
        }
        return result;
    }

    private static int insertSorted(int[] arr, int size, int num) {
        int i = size - 1;
        while (i >= 0 && arr[i] > num) {
            arr[i + 1] = arr[i];
            i--;
        }
        arr[i + 1] = num;
        return size + 1;
    }


    public static Set<Integer> mergeTreeSet(int[] a, int[] b) {
        if (a == null) {
            a = new int[0];
        }
        if (b == null) {
            b = new int[0];
        }

        Set<Integer> set = new TreeSet<>();
        for (int i : a) {
            set.add(i);
        }
        for (int i : b) {
            set.add(i);
        }

        return set;
    }

    public static int[] mergeArray(int[] a, int[] b) {

        int[] merged = new int[a.length+b.length];
        int j=0;
        int i=0;
        for (i=0;i<=a.length;i++){
            while (j<b.length){
                if (a[i] <b[j]) {
                    merged[i + j] = a[i];
                    if (i!=a.length-1)
                        break;
                }
                else {
                    merged[i + j] = b[j];
                }
                j++;
//                if (j==b.length)
//                    merged[i + j] = a[i];
//                if(i==a.length-1)  {
//                    merged[i + j] = b[i];
//                }
            }

        }

        return merged;
    }

}
