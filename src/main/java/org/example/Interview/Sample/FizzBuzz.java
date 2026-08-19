package org.example.Interview.Sample;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class FizzBuzz {

    /**
     * FizzBuzz: Print numbers 1 to 100, replacing multiples of 3 with "Fizz",
     * multiples of 5 with "Buzz", and both with "FizzBuzz".
     */

    public static void main(String[] args) {

        for(int i=1;i<=100;i++){
            if(i%3==0 && i%5==0){
                System.out.println("FizzBuzz");
            }
            else if(i%3!=0 && i%5==0){
                System.out.println("Fizz");
            }
            else if(i%3==0){
                System.out.println("Buzz");
            }
            else
                System.out.println(i);

        }
    }


}

