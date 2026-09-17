package org.example.Interview.Sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class questions {


    public static void main(String[] args) {

//        Question 1: Write a Java Program to reverse a String.
        String strRev = "abrycd";
//        System.out.println("strRev:- "+strRev(strRev));

        String str1 = "asdr";
        String str2 = "poiu";
//        swap(str1,str2);

//        Question 3: Write a Java Program to print the Fibonacci Series.
        int start = 0;
        int next = 1;
        int term = 10;
//        System.out.println("Febi:-" + Febi(start,next,term));

        //Question 4: Write a Java Program to check if a number is Armstrong number or not.
        int number = 23;
//        System.out.println("is Armstrong number:-" + isArmstrong(number));

//        Question 6: Write a Java Program to check if a number is Prime or not.
//        System.out.println("is Prime number:-" + isprime(number));

        //Question 12: Write a Java Program to find the longest consecutive occurrence of integers in a given array.

        int[] array = {1, 2, 3, 10, 5,6,7,8};
//        int[] array = {1};
        System.out.println("longest consecutive occurrence is:-" + longOccur(array));
    }


    public static String strRev(String s){

        char[] c = s.toCharArray();
        int left =0;
        int right = s.length()-1;
        while(left<right) {
            char temp = c[left];
            c[left] = c[right];
            c[right] = temp;
            left++;
            right--;
        }
        return new String(c);

    }

    public static void swap(String s1, String s2){
            String temp = s1;
            s1 = s2;
            s2 = temp;
        System.out.println("s1:-"+s1);
        System.out.println("s2:-"+s2);


    }


    //0,1,1,2
    public static List<Integer> Febi(int a, int b, int count){
        List<Integer> febi = new ArrayList<>();
        for (int i=0;i<count;i++){
            febi.add(a);
            int temp = a;
            a= a+b;
            b = temp;
        }
        return febi;
    }


    public static boolean isArmstrong(int num){

        //int length = Integer.toString(num).length();
        int length = (num == 0) ? 1 : (int) Math.log10(num) + 1;
        double sum = 0;
        int ori_num = num;
        while (num>0){
           int a = num%10;
           num = num/10;
           sum = sum + Math.pow(a,length);
        }
        return ori_num == sum;
    }

    public static boolean isArmstrong2(int num) {
        if (num < 0) return false;

        int length = (num == 0) ? 1 : (int) Math.log10(num) + 1;
        int sum = 0;
        int temp = num;

        while (temp > 0) {
            int digit = temp % 10;
            int power = 1;
            for (int i = 0; i < length; i++) power *= digit;
            sum += power;
            temp /= 10;
        }
        return sum == num;
    }

    public static boolean isprime(int num){

        if (num == 0 || num==1)
            return false;
        if ( num ==2)
            return true;
        for (int i=3;i<num;i++){
            if (num%i == 0){
                return false;
            }
        }
        return true;


    }


    public static int longOccur(int[] array){

        if (array ==null || array.length==0){
            return 0;
        }
        int count = 1;
        int max = 1;

        for (int i=1;i<array.length;i++){

            if (array[i]==array[i-1]+1){
                count++;
            }
            else {
                count = 1;
            }
            max = Math.max(count,max);
        }
    return max;
    }

}

