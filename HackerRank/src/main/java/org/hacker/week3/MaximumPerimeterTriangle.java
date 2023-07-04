package org.hacker.week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaximumPerimeterTriangle {
    public static void main(String[] args) {
        List<Integer> sticks = Arrays.asList(3,9,2,15,3);
        System.out.println(maximumPerimeterTriangle(sticks));
    }

    public static List<Integer> maximumPerimeterTriangle(List<Integer> sticks) {
        Collections.sort(sticks);
        for (int i = sticks.size() -1; i >= 2 ; i--) {
            if (sticks.get(i - 1) + sticks.get(i - 2) > sticks.get(i)) {
                return Arrays.asList(sticks.get(i - 2), sticks.get(i - 1), sticks.get(i));
            }
        }
        return Collections.singletonList(-1);
    }
}
