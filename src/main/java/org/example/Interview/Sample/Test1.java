package org.example.Interview.Sample;

public class Test1 {

    public static void main(String[] args){

        String str1 = "Testing";

        int left = 0;
        int right = str1.length() - 1;
        char[] cstr1 = str1.toCharArray();

        while(right>left){
            char temp = cstr1[left];
            cstr1[left] = cstr1[right];
            cstr1[right]= temp;
            left++;
            right--;
        }
        System.out.println(new String(cstr1));

    }
}
