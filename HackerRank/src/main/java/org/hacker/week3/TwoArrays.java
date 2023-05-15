package org.hacker.week3;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static javafx.scene.input.KeyCode.K;

public class TwoArrays {
    public static void main(String[] args) {
        System.out.println(twoArrays(10, Arrays.asList(2, 1, 3), Arrays.asList(7, 8, 9)));
        System.out.println(twoArrays(5, Arrays.asList(1, 2, 2, 1), Arrays.asList(3, 3, 3, 4)));

    }
    public static String twoArrays(int k, List<Integer> A, List<Integer> B) {
        A.sort(Comparator.comparingInt(o -> o));
        B.sort((o1, o2) -> o2 - o1);
        for (int i = 0; i < A.size(); i++) {
            if ((A.get(i) + B.get(i)) < k) {
                return "NO";
            }
        }
        return "YES";
    }
}
