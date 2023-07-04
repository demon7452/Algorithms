package org.hacker.week4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PickingNumbers {
    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(4 ,6 ,5 ,3 ,3 ,1);
        System.out.println(pickingNumbers(a));
    }

    public static int pickingNumbers(List<Integer> a) {
        Map<Integer, Integer> numToCountMap = new HashMap<>();
        for (Integer num : a) {
            numToCountMap.put(num, numToCountMap.getOrDefault(num, 0) + 1);
        }
        int maxLength = 1;
        for (Integer num : numToCountMap.keySet()) {
            int count1 = numToCountMap.get(num);
            int count2 = numToCountMap.getOrDefault(num + 1, 0);
            maxLength = Math.max(maxLength, count1 + count2);
        }
        return maxLength;
    }


    // 滑块方法，理解不对
    public static int pickingNumbers2(List<Integer> a) {
        int start = 0;
        int end = 1;
        int maxLength = 1;
        while (end < a.size()) {
            int sub = Math.abs(a.get(end) - a.get(end -1));
            if (sub <= 1) {
                end++;
                maxLength = Math.max(maxLength, end - start);
            }else {
                start = end;
                end++;
            }
        }
        return maxLength;
    }
}

