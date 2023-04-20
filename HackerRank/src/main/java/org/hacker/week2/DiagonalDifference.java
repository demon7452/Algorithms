package org.hacker.week2;

import java.util.Arrays;
import java.util.List;

public class DiagonalDifference {

    public static void main(String[] args) {
        List<List<Integer>> arr = Arrays.asList(
                Arrays.asList(1,2,3),
                Arrays.asList(4,5,6),
                Arrays.asList(9,8,9)
                );
        System.out.println(diagonalDifference(arr));
    }

    public static int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int sum1 = 0;
        for (int i = 0; i < arr.size(); i++) {
            sum1 += arr.get(i).get(i);
        }
        int sum2 = 0;
        for (int i = arr.size() - 1, j = 0; j < arr.size(); i--, j++) {
            sum2 += arr.get(i).get(j);
        }
        return Math.abs(sum1 - sum2);
    }

    public static int diagonalDifference2(List<List<Integer>> arr) {
        // Write your code here
        int diagonal1 = 0;
        int diagonal2 = 0;
        int n = arr.size();
        for (int i = 0; i < n; i++) {
            diagonal1 += arr.get(i).get(i);
            diagonal2 += arr.get(i).get(n - i - 1);
        }
        return Math.abs(diagonal1 - diagonal2);
    }
}
