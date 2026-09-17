package org.example.Interview.StringManipulationQuestions;

import java.util.HashMap;
import java.util.Map;

public class Q16_StringLinking {
    public static void main(String[] args) {

        String[] arr = { "Ab", "buZ"};

        Map<Character, String> map = new HashMap<>();

        // First character -> string
        for (String str : arr) {
            map.put(Character.toLowerCase(str.charAt(0)), str);
        }

        // Chain always starts with 'a'
        String current = map.get('a');
        StringBuilder result = new StringBuilder(current);

        // We already used the first string
        for (int i = 1; i < arr.length; i++) {
            char lastChar = current.charAt(current.length() - 1);
            current = map.get(lastChar);
            result.append(current.substring(1));
        }

        System.out.println(result);
    }

}
