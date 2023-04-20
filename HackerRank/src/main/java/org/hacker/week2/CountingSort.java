package org.hacker.week2;

import java.util.*;
import java.util.stream.Collectors;

public class CountingSort {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1,1,3,2,1,4,6,3,2,7,6,11,24,0);
        System.out.println(countingSort2(arr));
        System.out.println(countingSort3(arr));

    }

    public static List<Integer> countingSort(List<Integer> arr) {
        // Write your code here
        Map<Integer, Integer> numToCountMap = new HashMap<>();
        for (Integer num : arr) {
            numToCountMap.put(num, numToCountMap.getOrDefault(num, 0) + 1);
        }
        List<Integer> result = new ArrayList<>(100);
        for (int i = 0; i < 100; i++) {
            result.add(numToCountMap.getOrDefault(i, 0));
        }
        return result;
    }

    public static List<Integer> countingSort3(List<Integer> arr) {
        int[] count = new int[100];
        for (Integer num : arr) {
            count[num]++;
        }
        return Arrays.stream(count).boxed().collect(Collectors.toList());
    }

    public static List<Integer> countingSort2(List<Integer> arr) {
        int max = Collections.max(arr);
        int[] count = new int[max + 1];
        for (int num : arr) {
            count[num]++;
        }
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        int[] sortedArr = new int[arr.size()];
        for (Integer num : arr) {
            int index = count[num] - 1;
            sortedArr[index] = num;
            count[num]--;
        }
        return Arrays.stream(sortedArr).boxed().collect(Collectors.toList());
    }
}
