package org.hacker.week2;

import java.util.List;

public class FlippingMatrix {
    public static void main(String[] args) {

    }

    public static int flippingMatrix(List<List<Integer>> matrix) {
        int n = matrix.size() / 2;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int max = matrix.get(i).get(j);
                max = Math.max(max, matrix.get(i).get(matrix.size() - 1 - j));
                max = Math.max(max, matrix.get(matrix.size() - 1 - i).get(j));
                max = Math.max(max, matrix.get(matrix.size() - 1 - i).get(matrix.size() - 1 - j));
                sum += max;
            }
        }
        return sum;
    }
}
