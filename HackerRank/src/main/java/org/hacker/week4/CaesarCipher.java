package org.hacker.week4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CaesarCipher {
    public static void main(String[] args) {
        String lower = "[a-z]";
        String upper = "[A-Z]";
        System.out.println(Pattern.matches(lower, "A"));
        System.out.println(Pattern.matches(upper, "A"));
        System.out.println(Pattern.matches(lower, "1"));
        char a1 = 'b';
        System.out.println((char)(a1 + 25 - 'z'));

    }

    public static String caesarCipher(String s, int k) {
        k = k % 26;
        String lower = "[a-z]";
        String upper = "[A-Z]";
        StringBuilder result = new StringBuilder();
        for (char var : s.toCharArray()) {
            if (Pattern.matches(lower, String.valueOf(var))) {
                int end = var + k;
                if (end > 'z') {
                    result.append((char)(end - 'z' + 'a' - 1));
                }else {
                    result.append((char)end);
                }
            }else if (Pattern.matches(upper, String.valueOf(var))) {
                int end = var + k;
                if (end > 'Z') {
                    result.append((char)(end - 'Z' + 'A' - 1));
                }else {
                    result.append((char)end);
                }
            }else {
                result.append(var);
            }
        }
        return result.toString();
    }
}
