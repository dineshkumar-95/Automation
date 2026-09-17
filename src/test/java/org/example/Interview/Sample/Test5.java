package org.example.Interview.Sample;

import java.util.*;

public class Test5 {

    public static void main(String[] args) {
        String str = "abcdabceade";
        char target = 'a';

        int[] arr = {1, 3, 2, 3, 4, 1, 5, 5, 5};
//        System.out.println("countOccurrence: " + countOccurrence(str,target));

        System.out.println("findDuplicates: " + findDuplicates(arr));

//        System.out.println("Sliding window + Map (best): " + lengthOfLongestSubstringUsingMap(str));
        System.out.println("findNthMax: " + findNthMax(arr,1));
    }

    public static int countOccurrence(String str, char target) {

        if (str == null)
            return 0;

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == target) {
                count++;
            }

        }
        return count;
    }


    public static List<Integer> findDuplicates(int[] arr) {

        List<Integer> target = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j] && !target.contains(arr[i])) {
                    target.add(arr[i]);
                    break;
                }
            }
        }
        return target;
    }

    public static int findNthMax(int[] arr, int nthMax){

        int count = 0;
        int r = 0;
        Set<Integer> set = new TreeSet<>();
        for (int a: arr){
            set.add(a);
        }
        for(int c : set){
            count++;
            if (count==(set.size()-nthMax+1))
                return c;
        }
        return r;
    }


}

