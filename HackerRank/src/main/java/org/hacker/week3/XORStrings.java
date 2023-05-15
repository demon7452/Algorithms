package org.hacker.week3;

import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import java.io.*;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class XORStrings {
    public static void main(String[] args) throws IOException {

        System.out.println(xorStrings4("10101", "00101"));
        System.out.println(stringsXOR3("10101", "00101"));
    }

    public static String stringsXOR(String s, String t) {
        long num1 = Long.parseLong(s, 2);
        long num2 = Long.parseLong(t, 2);
        String binaryResult = Long.toBinaryString(num1 ^ num2);
        if (binaryResult.length() >= s.length()) {
            return binaryResult;

        }
        int count = s.length() - binaryResult.length();
        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            resultBuilder.append("0");
        }
        resultBuilder.append(binaryResult);
        return resultBuilder.toString();
    }

    public static String xorStrings(String s1, String s2) {
        if (s1.length() != s2.length()) {
            throw new IllegalArgumentException("Strings must have equal length");
        }
        char[] result = new char[s1.length()];
        for (int i = 0; i < s1.length(); i++) {
            result[i] = (char)(s1.charAt(i) ^ s2.charAt(i));
        }
        return new String(result);
    }

    public static String xorStrings2(String s1, String s2) {
        StringBuilder result = new StringBuilder(s1.length());
        for (int i = 0; i < s1.length(); i++) {
            result.append(s1.charAt(i) ^ s2.charAt(i));
        }
        return result.toString();
    }

    public static String xorStrings4(String s, String t) {
        String res = new String("");
        for (int i = 0; i < s.length(); i++) {
            res += s.charAt(i) ^ t.charAt(i);
        }
        return res;
    }

    public static String xorStrings5(String s, String t) {
        String res = new String("");
        for (int i = 0; i < s.length(); i++) {
            int re = s.charAt(i) ^ t.charAt(i);
            if (re == 0) {
                res += "0";
            } else {
                res += "1";
            }
        }
        return res;
    }
    public static String stringsXOR3(String s, String t) {
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == t.charAt(i))
                res.append("0");
            else
                res.append("1");
        }

        return res.toString();
    }
}
