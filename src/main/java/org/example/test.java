package org.example;

public class test {
    public static void main(String[] args) {

        // Reverse String
        String original = "hello";
        System.out.println("reverseStringWithoutMethods : " + reverseStringTwoPointer(original));
//        System.out.println("Original: " + original);
//        System.out.println("Two-pointer swap: " + reverseStringTwoPointer(original));
//        System.out.println("Loop: " + reverseStringUsingLoop(original));
//        System.out.println("Recursion: " + reverseStringUsingRecursion(original));
        System.out.println("StringBuilder : " + reverseStringUsingStringBuilder(original));
        System.out.println("StringBuffer : " + reverseStringUsingStringBuffer(original));
    }

    // Method 1: Two-pointer swap on char array
    public static String reverseStringTwoPointer(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        char[] chars = str.toCharArray();
        int left = 0;
        int right = chars.length - 1;
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }

    // Method 2: Build reversed string by iterating from end to start
    public static String reverseStringUsingLoop(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        char[] reversed = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            reversed[i] = str.charAt(str.length() - 1 - i);
        }
        return new String(reversed);
    }

    // Method 3: Recursive approach
    public static String reverseStringUsingRecursion(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }

        return reverseStringUsingRecursion(str.substring(1)) + str.charAt(0);
    }

    // Method 4: StringBuilder — append chars manually (no reverse())
    public static String reverseStringUsingStringBuilder(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        String a = sb.reverse().toString();
        return sb.toString();
    }
    public static String reverseStringUsingStringBuffer(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        return new StringBuffer(str).reverse().toString();
    }
}
