package org.hacker.week5;

import java.util.HashMap;
import java.util.Map;

public class Anagram {

    public static void main(String[] args) {
        System.out.println(anagram("aaabbb"));
        System.out.println(anagram("ab"));
        System.out.println(anagram("abc"));
        System.out.println(anagram("mnop"));
        System.out.println(anagram("xyyx"));
        System.out.println(anagram("xaxbbbxx"));
    }

    public static int anagram(String s) {
        // Write your code here
        if (s.length() % 2 != 0) {
            return -1;
        }
        int mid = s.length() / 2;
        String fistHalf = s.substring(0, mid);
        String secondHalf = s.substring(mid);
        Map<String, Integer> characterToCountMap = new HashMap<>();
        for (char c : fistHalf.toCharArray()) {
            String key =  String.valueOf(c);
            characterToCountMap.put(key, characterToCountMap.getOrDefault(key, 0) + 1);
        }
        for (char c : secondHalf.toCharArray()) {
            String key =  String.valueOf(c);
            if (characterToCountMap.containsKey(key)) {
                int count = characterToCountMap.get(key) - 1;
                characterToCountMap.put(key, Math.max(count, 0));
            }
        }
        int sum = 0;
        for (Integer count : characterToCountMap.values()) {
            sum += count;
        }
        return sum;
    }
}
