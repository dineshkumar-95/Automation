package org.example.Interview.Sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Test6 {

    public static void main(String[] args) {
        String str = "11111.11111.11111.2346543";

        System.out.println(count(str));

    }

    public static String count(String str) {

        String[] aStr = str.split("\\.");
        StringBuilder sb = new StringBuilder();

        for (String s : aStr){
            for (int i=0;i<s.length();i++){
                while (s.length()>1){
                    s = sum(s);
                }
                sb.append(".").append(s);
            }
        }
        sb.deleteCharAt(0);
        return sb.toString();
    }

    private static String sum(String s){
        int sum =0;
        for (int i=0;i<s.length();i++){
            sum = sum+ Character.getNumericValue(s.charAt(i));
        }
        return Integer.toString(sum);
    }


}

