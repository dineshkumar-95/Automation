package org.example.Interview.Sample;

import java.util.HashSet;
import java.util.Set;

public class nthlargest {

    public static void main(String[] args) {
        int[] nums = {1,5,10,6,99};
        int nth_large = 6;
        System.out.println(nth_large+ " position large number in give array" + nthLarge(nums,nth_large));
    }

    public static int nthLarge(int[] nums, int nth_large) {

        int nthmax = 0;
        Set<Integer> set_nums = new HashSet<>();
        for (int num: nums){
            set_nums.add(num);
        }

        return 2;
    }


}

