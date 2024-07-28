package org.hacker.week5;

import java.util.*;
import java.util.stream.Collectors;

public class MissingNumbers {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(203, 204 ,205 ,206 ,207 ,208 ,203 ,204, 205 ,206);
        List<Integer> brr = Arrays.asList(203, 204, 204, 205, 206, 207, 205, 208, 203, 206, 205, 206, 204,204);
        System.out.println(missingNumbers2(arr, brr));
    }

    public static List<Integer> missingNumbers(List<Integer> arr, List<Integer> brr) {
        // Write your code here
        Map<Integer, Integer> numToCountMap = new HashMap<>();
        for (Integer num : brr) {
            numToCountMap.put(num, numToCountMap.getOrDefault(num, 0) + 1);
        }
        for (Integer num : arr) {
            numToCountMap.put(num, numToCountMap.getOrDefault(num, 0) - 1);
        }
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : numToCountMap.entrySet()) {
            if (entry.getValue() != 0) {
                result.add(entry.getKey());
            }
        }
        return result.stream().sorted().collect(Collectors.toList());
    }

    public static List<Integer> missingNumbers2(List<Integer> arr, List<Integer> brr) {
        Set<Integer> missingNumbersList = new HashSet<>();

        // Sort both lists
        Collections.sort(arr);
        Collections.sort(brr);

        int pointerA = 0; // Pointer for arr
        int pointerB = 0; // Pointer for brr

        // Traverse both lists using pointers
        while (pointerB < brr.size()) {
            if (pointerA == arr.size() || !Objects.equals(arr.get(pointerA), brr.get(pointerB))) {
                // If pointerA has reached the end of arr or if the elements at pointers don't match,
                // add the element from brr to missingNumbersList
                missingNumbersList.add(brr.get(pointerB));
                pointerB++;
            } else {
                // If elements match, move both pointers ahead
                pointerA++;
                pointerB++;
            }
        }

        return new ArrayList<>(missingNumbersList);
    }

}
