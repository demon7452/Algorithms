package org.hacker.week2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LonelyInteger {
    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(1,2,3,4,3,2,1);
        System.out.println(lonelyInteger2(a));
    }

    public static int lonelyInteger(List<Integer> a) {
        Map<Integer, Integer> numToCountMap = new HashMap<>();
        a.forEach(num -> numToCountMap.put(num, numToCountMap.getOrDefault(num, 0) + 1));

        for (Map.Entry<Integer, Integer> entry : numToCountMap.entrySet()) {
            if (1 == entry.getValue()) {
                return entry.getKey();
            }
        }
        return -1;
    }

    /**
     *
     * @param a
     * @return
     */
    public static int lonelyInteger2(List<Integer> a) {
        int result = 0;
        for (Integer num : a) {
            result ^= num;
        }
        return result;
    }
}