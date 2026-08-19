package org.example.Interview.Sample;

import java.util.*;

public class StandardBrackets {


    public static void main(String[] args) {
        String s = "[{}{}({}[])]";
//        System.out.println(isValidBrackets(s)); // Returns true
//        System.out.println(isValidBrackets3(s)); // Returns true
//        System.out.println(isValidBracketsFast(s)); // Returns false

        String b = "aabbccc";
//        System.out.println(stringCompression(b));

        int[] nums = {2, 2,7, 11, 7,15,6,3,2};
        int target = 9;

        System.out.println(twoSum(nums,target));
        System.out.println(twoSumOptimal(nums,target));
        System.out.println(twoSumOptimal2(nums,target));
    }


    public static boolean isValidBrackets(String s) {
        Stack<Character> stack = new Stack<>();

        // Map closing brackets to their corresponding opening brackets
        Map<Character, Character> bracketMap = new HashMap<>();
        bracketMap.put(')', '(');
        bracketMap.put('}', '{');
        bracketMap.put(']', '[');

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // If it is an opening bracket, push to stack
            if (bracketMap.containsValue(ch)) {
                stack.push(ch);
            }
            // If it is a closing bracket
            else if (bracketMap.containsKey(ch)) {
                // Invalid if no matching opening bracket exists
                if (stack.isEmpty()) {
                    return false;
                }
                // Invalid if it doesn't match the top of the stack
                if (stack.pop() != bracketMap.get(ch)) {
                    return false;
                }
            }
        }
        // Valid only if all opened brackets are successfully matched and popped
        return stack.isEmpty();
    }


    public static boolean isValidBracketsFast(String s) {
        // A string with odd length can never be balanced
        if (s.length() % 2 != 0) return false;

        char[] stack = new char[s.length()];
        int head = 0; // Pointer for the top of the stack

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case '(':
                case '{':
                case '[':
                    stack[head++] = ch; // Push
                    break;
                case ')':
                    if (head == 0 || stack[--head] != '(')
                        return false; // Pop & Check
                    break;
                case '}':
                    if (head == 0 || stack[--head] != '{')
                        return false;
                    break;
                case ']':
                    if (head == 0 || stack[--head] != '[')
                        return false;
                    break;
                default:
                    // Ignore non-bracket characters if string contains text
                    break;
            }
        }
        return head == 0;
    }


    public static boolean isValidBrackets2(String s) {

        if (s ==null || s.length()%2==1)
            return false;

        Map<Character, Character> map = new HashMap<>();
        map.put('{','}');
        map.put('[',']');
        map.put('(',')');
        char[] cLeft = new char[s.length()/2];
        char[] cRight = new char[s.length()/2];

        int right = s.length() - 1;
        for (int i=0;i<s.length()/2;i++){
            cLeft[i]=s.charAt(i);
            cRight[i]=s.charAt(right);
            right--;
        }
        for (int i=0;i<cLeft.length;i++){
            if (!map.get(cLeft[i]).equals(cRight[i]))
                return false;
        }
        return true;
    }

    public static boolean isValidBrackets3(String s) {

        if (s ==null || s.length()%2==1)
            return false;

        StringBuilder sb = new StringBuilder();
        sb.append(s);

        while (s.contains("()") || s.contains("{}") || s.contains("[]")){
            s = s.replace("()","");
            s = s.replace("{}","");
            s = s.replace("[]","");
        }
        return s.isEmpty();
    }

    public static String stringCompression(String s) {

        if (s ==null || s.isEmpty())
            return null;
        StringBuilder sb = new StringBuilder();
        int count =1;
        char[] chars = s.toCharArray();

        //"aabcccccaaa"

        for (int i=1; i<s.length();i++){
            //count++;
            if (chars[i]==chars[i-1]){
                count++;
            }
            if (chars[i]!=chars[i-1]) {
                sb.append(chars[i-1]).append(count);
                count = 1;
            }
        }
        sb.append(chars[s.length()-1]).append(count);


//        return sb.toString();
        return sb.length()<s.length() ? sb.toString() :s;

    }




//    int[] nums = {2, 2,7, 11, 7,15,6,3,2};
//    int target = 9;
    public static List<List<Integer>> twoSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i=0;i<nums.length;i++){
            if (nums[i]<=target){
                for (int j =i+1; j<nums.length;j++){
                    if (nums[j]<=target && nums[i]+nums[j]==target){
                        List<Integer> newlist = new ArrayList<>();
                        newlist.add(nums[i]);
                        newlist.add(nums[j]);
//                        if (!list.contains(newlist))
                            list.add(newlist);
                    }
                }
            }
        }
        return list;
    }

    public static List<List<Integer>> twoSumOptimal(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            int minus = target - num;
            if (set.contains(minus)) {
                List<Integer> pair = new ArrayList<>();
                pair.add(minus);
                pair.add(num);
                if (!list.contains(pair))
                    list.add(pair);
            }
            set.add(num);
        }

        return list;
    }

//    int[] nums = {2, 2,7, 11, 15,6,3};
//    int target = 9;
    public static List<List<Integer>> twoSumOptimal2(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            int minus = target - num;
            if (set.contains(minus)) {
                if (!list.contains(Arrays.asList(minus,num)) && !list.contains(Arrays.asList(num,minus)))
//                if (!list.contains(Arrays.asList(minus,num)))
                    list.add(Arrays.asList(minus,num));
            }
            set.add(num);
        }

        return list;
    }


}


