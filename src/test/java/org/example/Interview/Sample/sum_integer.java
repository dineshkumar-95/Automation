package org.example.Interview.Sample;

public class sum_integer {

    public static void main(String[] args) {
        String str = "2432.5555.23456543.9999";
        //output = 6.1.9
        System.out.println(sum2(str));
        System.out.println(sum(str));
    }

    public static String sum(String str) {
        String[] aStr = str.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (String a : aStr) {
            while (a.length() != 1) {
                a = sumint(a);
            }
            sb.append(".").append(a);
        }
        sb.deleteCharAt(0);
        return sb.toString();

    }

    private static String sumint(String a) {
        int count = 0;
        {
            for (int i = 0; i < a.length(); i++) {
                count = count + Character.getNumericValue(a.charAt(i));
            }
            return Integer.toString(count);

        }
    }


    public static String sum2(String str) {
        String[] aStr = str.split("\\.");
        StringBuilder sb = new StringBuilder();

        for (String a : aStr) {
            int num = Integer.parseInt(a);
//            int singleDigit = (num == 0) ? 0 : (num % 9 == 0 ? 9 : num % 9);
            int singleDigit = (num == 0) ? 0 : 1 + (num - 1) % 9;
            sb.append(".").append(singleDigit);
        }
        sb.deleteCharAt(0); // Removes the leading dot
        return sb.toString();
    }


}

