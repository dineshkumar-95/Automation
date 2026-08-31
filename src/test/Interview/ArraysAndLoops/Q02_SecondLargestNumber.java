package org.example.Interview.ArraysAndLoops;

import java.util.*;

/**
 * Second Largest Number: Find the second largest integer in a single-dimensional numeric array.
 */
public class Q02_SecondLargestNumber {
    public static void main(String[] args) {
        int[] arr = {-10, -20, -5, -30};
        int nthMax = 2;
        System.out.println("Single pass (best): " + secondLargest(arr));
//        System.out.println("Single pass (best): " + secondLargestSinglePass(arr));
//        System.out.println("Two passes: " + secondLargestTwoPasses(arr));
//        System.out.println("Sorting: " + secondLargestUsingSort(arr.clone()));
//        System.out.println("nthmax: " + findNthMax(arr,nthMax));
        System.out.println("nthmax: " + findNthMaxIte(arr,nthMax));
    }


    public static Integer secondLargest(int[] arr) {
        if (arr == null) {
            return null;
        }

        Integer largest = null;
        Integer second = null;
        for (int num : arr){
            if (largest ==null || num>largest){
                second = largest;
                largest = num;
            }
            else if (second ==null|| (num>second && num<largest )){
                second = num;
            }
        }
        return second;

    }

    public static Integer findNthMax(int[] arr, int nthMax){
        if (arr == null || nthMax <= 0) {
            return null;
        }

        int count = 0;
        Integer nthmax = null;
        Set<Integer> set = new TreeSet<>();
        for (int a: arr){
            set.add(a);
        }
        for(int c : set){
            count++;
            if (count==(set.size()-nthMax+1))
                nthmax= c;
        }
        return nthmax;
    }

    public static Integer findNthMax2(int[] arr, int nthMax){
        if (arr == null || nthMax <= 0) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        for (int num : arr){
            if (!list.contains(num)){
                list.add(num);
            }
        }
        Collections.sort(list);
        return list.get(list.size()-nthMax);

    }

    public static Integer findNthMaxList(int[] arr, int nthMax) {
        if (arr == null || arr.length == 0 || nthMax <= 0) {
            return null;
        }

        Set<Integer> set = new TreeSet<>();

        for (int num : arr) {
            set.add(num);
        }

        if (nthMax > set.size()) {
            return null;
        }

        List<Integer> list = new ArrayList<>(set);
        return list.get(list.size()-nthMax);
    }

    public static Integer findNthMaxIte(int[] arr, int nthMax) {
        if (arr == null || arr.length == 0 || nthMax <= 0) {
            return null;
        }

        NavigableSet<Integer> set = new TreeSet<>();

        for (int num : arr) {
            set.add(num);
        }

        if (nthMax > set.size()) {
            return null;
        }

        Iterator<Integer> iterator = set.descendingIterator();

        for (int i = 1; i < nthMax; i++) {
            iterator.next();
        }

        return iterator.next();
    }

    // Best: one pass tracking largest and second — O(n) time, O(1) space
    public static Integer secondLargestSinglePass(int[] arr) {
        if (arr == null || arr.length < 2) {
            return null;
        }
        Integer largest = null;
        Integer second = null;
        for (int num : arr) {
            if (largest == null || num > largest) {
                second = largest;
                largest = num;
            } else if (num != largest && (second == null || num > second)) {
                second = num;
            }
        }
        return second;
    }

    // Two passes: find max, then find max less than that — O(n) time
    public static Integer secondLargestTwoPasses(int[] arr) {
        if (arr == null || arr.length < 2) {
            return null;
        }
        int largest = arr[0];
        for (int num : arr) {
            if (num > largest) {
                largest = num;
            }
        }
        Integer second = null;
        for (int num : arr) {
            if (num != largest && (second == null || num > second)) {
                second = num;
            }
        }
        return second;
    }

    // Least optimal: sort and walk from end — O(n log n)
    public static Integer secondLargestUsingSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return null;
        }
        Arrays.sort(arr);
        int largest = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] != largest) {
                return arr[i];
            }
        }
        return null;
    }
}
