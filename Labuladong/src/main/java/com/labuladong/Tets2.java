package com.labuladong;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Tets2 {
    public static void main(String[] args) {

    }

    public static void closestNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
        Set<Integer> set = new HashSet<>(numbers);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < numbers.size(); i++) {
            min = Math.min(min, numbers.get(i) - numbers.get(i - 1));
        }
        for (Integer number : numbers) {
            int target = number + min;
            if (set.contains(target)) {
                System.out.println(number + " " + target);
            }
        }
    }
}
