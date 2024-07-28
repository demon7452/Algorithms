package org.hacker.week5;

import java.util.Collections;
import java.util.List;

public class MaxMin {
    public static int maxMin(int k, List<Integer> arr) {
        // Write your code here
        Collections.sort(arr);
        int minSub = Integer.MAX_VALUE;
        for (int i = 0; i <= arr.size() - k; i++) {
            int curSub = arr.get(i + k - 1) - arr.get(i);
            minSub = Math.min(curSub, minSub);
        }
        return minSub;
    }

}
