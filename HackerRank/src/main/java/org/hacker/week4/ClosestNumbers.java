package org.hacker.week4;

import java.util.*;

public class ClosestNumbers {

    public static List<Integer> closestNumbers(List<Integer> arr) {
        // Write your code here
        Collections.sort(arr);
        Map<Integer, List<Integer>> subToListMap = new HashMap<>();
        int minSub = Integer.MAX_VALUE;
        for (int i = 1; i < arr.size(); i++) {
            int sub = arr.get(i) - arr.get(i -1);
            if (subToListMap.containsKey(sub)) {
                subToListMap.get(sub).add(arr.get(i-1));
                subToListMap.get(sub).add(arr.get(i));
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(arr.get(i-1));
                list.add(arr.get(i));
                subToListMap.put(sub, list);
            }
            minSub = Math.min(sub, minSub);
        }
        return subToListMap.get(minSub);
    }
}
