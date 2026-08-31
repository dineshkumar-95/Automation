package org.example.Interview.StringManipulationQuestions;

/**
 * Count Vowels and Consonants: Count vowels and consonants in an alphanumeric string,
 * ignoring numbers and special characters.
 * SDET: Text analysis and search filter testing on content-heavy websites.
 */
public class Q15_CountVowelsAndConsonants {
    public static void main(String[] args) {
        String str = "Hello World 123!";
        int[] result = countUsingLoop(str);
        System.out.println("Loop (best): vowels=" + result[0] + ", consonants=" + result[1]);
        int[] stream = countUsingStream(str);
        System.out.println("Stream: vowels=" + stream[0] + ", consonants=" + stream[1]);
        System.out.println("Switch: " + java.util.Arrays.toString(countUsingSwitch(str)));
    }

    // Best: single pass — O(n) time, O(1) space; result[0]=vowels, result[1]=consonants
    public static int[] countUsingLoop(String str) {
        int vowels = 0;
        int consonants = 0;
        if (str == null || str.isEmpty()) {
            return new int[]{0, 0};
        }
        for (int i = 0; i < str.length(); i++) {
            char c = Character.toLowerCase(str.charAt(i));
            if (c >= 'a' && c <= 'z') {
                if (isVowel(c)) {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }
        return new int[]{vowels, consonants};
    }

    // Stream API — concise, slight overhead
    public static int[] countUsingStream(String str) {
        if (str == null || str.isEmpty()) {
            return new int[]{0, 0};
        }
        int vowels = (int) str.chars()
                .map(Character::toLowerCase)
                .filter(c -> c >= 'a' && c <= 'z')
                .filter(c -> isVowel((char) c))
                .count();
        int letters = (int) str.chars()
                .map(Character::toLowerCase)
                .filter(c -> c >= 'a' && c <= 'z')
                .count();
        return new int[]{vowels, letters - vowels};
    }

    // Switch expression style count
    public static int[] countUsingSwitch(String str) {
        int vowels = 0;
        int consonants = 0;
        if (str == null || str.isEmpty()) {
            return new int[]{0, 0};
        }
        for (char ch : str.toCharArray()) {
            char c = Character.toLowerCase(ch);
            if (c < 'a' || c > 'z') {
                continue;
            }
            switch (c) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    vowels++;
                    break;
                default:
                    consonants++;
            }
        }
        return new int[]{vowels, consonants};
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
