package org.example.Interview.StringManipulationQuestions;

/**
 * String Compression: Perform basic string compression using the counts of repeated characters.
 * For example, "aabcccccaaa" would become "a2b1c5a3".
 * If the compressed string is not smaller than the original, return the original.
 */
public class Q06_StringCompression {
    public static void main(String[] args) {
        String str = "aabcccccaaa";
//        String str = "c";
        System.out.println("StringBuilder (best): " + compressUsingStringBuilder(str));
//        System.out.println("Char array: " + compressUsingCharArray(str));
//        System.out.println("String concat: " + compressUsingConcat(str));
        System.out.println("compressStringRaw: " + compressStringRaw(str));
    }


    // Best: O(n) time, O(n) space — StringBuilder avoids quadratic concat
    public static String compressUsingStringBuilder(String str) {
        if (str == null || str.isEmpty() ) {
            return str;
        }
        StringBuilder compressed = new StringBuilder();
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {
                compressed.append(str.charAt(i - 1)).append(count);
                count = 1;
            }
        }
        compressed.append(str.charAt(str.length() - 1)).append(count);

//        return compressed.length() < str.length() ? compressed.toString() : str;
        return compressed.toString();
    }

    // Same idea with char array / count-first to size the result — O(n) time
    public static String compressUsingCharArray(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        int compressedLength = countCompressedLength(str);
        if (compressedLength >= str.length()) {
            return str;
        }
        char[] result = new char[compressedLength];
        int index = 0;
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {
                index = appendCharAndCount(result, index, str.charAt(i - 1), count);
                count = 1;
            }
        }
        appendCharAndCount(result, index, str.charAt(str.length() - 1), count);
        return new String(result);
    }

    // Least optimal: String concat creates many intermediate objects — O(n^2) worst case
    public static String compressUsingConcat(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        String compressed = "";
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {
                compressed += str.charAt(i - 1) + String.valueOf(count);
                count = 1;
            }
        }
        compressed += str.charAt(str.length() - 1) + String.valueOf(count);
        return compressed.length() < str.length() ? compressed : str;
    }

    private static int countCompressedLength(String str) {
        int length = 0;
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {
                length += 1 + String.valueOf(count).length();
                count = 1;
            }
        }
        length += 1 + String.valueOf(count).length();
        return length;
    }

    private static int appendCharAndCount(char[] result, int index, char c, int count) {
        result[index++] = c;
        char[] countChars = String.valueOf(count).toCharArray();
        for (char digit : countChars) {
            result[index++] = digit;
        }
        return index;
    }




    public static String compressStringRaw(String str) {
        if (str == null || str.length() <= 2) {
            return str;
        }

        int n = str.length();
        // Allocate a char array matching the maximum possible size we care about
        char[] compressed = new char[n];
        int writeIndex = 0;
        int count = 1;

        for (int i = 0; i < n; i++) {
            if (i + 1 < n && str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } else {
                // 1. Write the character
                if (writeIndex >= n)
                    return str; // Optimization: early exit if count exceeds original length
                compressed[writeIndex++] = str.charAt(i);

                // 2. Convert count integer to characters and write them directly
                String countStr = String.valueOf(count);
                for (int j = 0; j < countStr.length(); j++) {
                    if (writeIndex >= n) return str; // Early exit
                    compressed[writeIndex++] = countStr.charAt(j);
                }

                count = 1; // Reset counter
            }
        }

        // 3. Return original if compressed version isn't actually shorter
        return writeIndex < n ? new String(compressed, 0, writeIndex) : str;
    }

}


