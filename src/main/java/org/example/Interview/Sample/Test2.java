package org.example.Interview.Sample;

public class Test2 {

    public static void main(String[] args){

        String str1 = "Testing";
        String str2 = "Testing";
        int sum1 = 0;
        int sum2 = 0;


        for (int i=0; i< str1.length();i++){
             sum1 = sum1+ str1.charAt(i);
             sum2 = sum2 + str2.charAt(i);
        }
        if (sum1==sum2)
            System.out.println("anagraam");

    }
}
