package org.hacker.week4;

import java.util.Collections;
import java.util.List;

public class MinimumAbsoluteDifference {
    public static void main(String[] args) {

    }

    public static int minimumAbsoluteDifference(List<Integer> arr) {
        // Write your code here
        Collections.sort(arr);
        int minimum = Integer.MAX_VALUE;
        for (int i = 1; i < arr.size(); i++) {
            int diff = arr.get(i) - arr.get(i -1);
            minimum = Math.min(minimum, diff);
        }
        return minimum;
    }
}
