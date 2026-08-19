package org.example.Interview.Sample;

public class Test3 {

    public static void main(String[] args) {
        String str = "aabcccccaaa";
        System.out.println("StringBuilder (best): " + compressUsingStringBuilder(str));
    }

    // Best: O(n) time, O(n) space — StringBuilder avoids quadratic concat
    public static String compressUsingStringBuilder(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        //StringBuilder compressed = new StringBuilder();
        int count = 1;
        int targetcount = 0;
        char[] newStr = new char[str.length()*2];
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {
                //compressed.append(str.charAt(i - 1)).append(count);
                for (int j=targetcount;j<newStr.length;j++){
                    if(j%2==0) {
                        newStr[j] = str.charAt(i - 1);
                        targetcount++;
                    }
                    else {
                        newStr[j] = (char) (count + '0');
                        targetcount++;
                        break;
                    }
                }
                count = 1;
            }
        }
        for (int j=targetcount;j<newStr.length;j++){
            if(j%2==0) {
                newStr[j] = str.charAt(str.length()-1);
                targetcount++;
            }
            else {
                newStr[j] = (char) (count + '0');
                break;
            }
        }
        //compressed.append(str.charAt(str.length() - 1)).append(count);
        return new String(newStr);
//        return compressed.length() < str.length() ? compressed.toString() : str;
    }


}
