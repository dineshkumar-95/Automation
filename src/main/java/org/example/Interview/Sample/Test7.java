package org.example.Interview.Sample;

public class Test7 {

    public static void main(String[] args) {
        String str = "199.11111.11111.2346543";

        System.out.println(sumOfDigits(str));

    }
    public static String sumOfDigits(String str){

        StringBuilder sb = new StringBuilder();
        String[] aStr = str.split("\\.");
        for (String s : aStr){
            sb.append(".").append(sumOfDigitsLoop(Integer.parseInt(s)));
        }
        sb.deleteCharAt(0);
        return sb.toString();
    }


    public static int sum(int num){
        int sum = 0;
        while(num>0){
            sum = sum + num%10;
            num = num/10;
        }

        if (sum>=10){
            sum(sum);
        }
        return sum;
    }

    public static int sumOfDigitsLoop(int num) {
        while (num >= 10) {
            int sum = 0;
            while (num > 0) {
                sum = sum + (num % 10);
                num = num / 10;
            }
            num = sum;
        }
        return num;
    }




}

