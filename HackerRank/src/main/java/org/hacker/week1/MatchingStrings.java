package org.hacker.week1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchingStrings {

    public static void main(String[] args) {

    }

    public static List<Integer> matchingStrings(List<String> strings, List<String> queries) {
        Map<String, Integer> stringToCountMap = new HashMap<>();
        for (String str : strings) {
            stringToCountMap.put(str, stringToCountMap.getOrDefault(str, 0) + 1);
        }
        List<Integer> count = new ArrayList<>();
        for (String query : queries) {
            count.add(stringToCountMap.getOrDefault(query, 0));
        }
        return count;
    }

}
