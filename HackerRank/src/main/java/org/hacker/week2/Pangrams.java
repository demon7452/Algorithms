package org.hacker.week2;

import java.util.*;

public class Pangrams {

    public static void main(String[] args) {
        System.out.println(pangrams("The quick brown fox jumps over the lazy dog"));
        System.out.println(pangrams("We promptly judged antique ivory buckles for the prize"));
        System.out.println(pangramsChatGpt("We promptly judged antique ivory buckles for the next prize"));
    }

    public static String pangrams(String s) {

        // Write your code here
        Set<String> letterSet = new HashSet<>();
        for (char c : s.toCharArray()) {
            letterSet.add(String.valueOf(c).toLowerCase());
        }
        String allLetters = "abcdefghijklmnopqrstuvwxyz";
        for (char letter : allLetters.toCharArray()) {
            if (!letterSet.contains(String.valueOf(letter))){
                return "not pangram";
            }
        }
        return "pangram";
    }
    public static String pangramsChatGpt(String s) {
        s = s.toLowerCase();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for (char letter : alphabet.toCharArray()) {
            if (s.indexOf(letter) == -1) {
                return "not pangram";
            }
        }
        return "pangram";
    }
}
