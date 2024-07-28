package cn.leetcode.arrayAndString;

import javax.print.DocFlavor;

public class ReverseWords {

    public static void main(String[] args) {
        String s = "a good   example";
        System.out.println(reverseWords(s));
    }
    public static String reverseWords(String s) {
        String[] wordArray = s.split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = wordArray.length - 1; i >= 0; i--) {
            if (!wordArray[i].equals("")) {
                result.append(wordArray[i]).append(" ");
            }
        }
        return result.substring(0, result.length() - 1);
    }
}
