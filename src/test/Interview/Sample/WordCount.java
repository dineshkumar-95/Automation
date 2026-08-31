package org.example.Interview.Sample;

import java.util.HashMap;
import java.util.Map;

public class WordCount {

    /**
     * FizzBuzz: Print numbers 1 to 100, replacing multiples of 3 with "Fizz",
     * multiples of 5 with "Buzz", and both with "FizzBuzz".
     */

    public static void main(String[] args) {

        String sentence = "Java is great and Java is powerful";

        System.out.println(count(sentence));
    }


    public static Map<String, Integer> count(String str) {
        Map<String, Integer> map = new HashMap<>();
        String[]  aStr = str.split(" ");
        for (String s : aStr){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        return map;



    }





}

