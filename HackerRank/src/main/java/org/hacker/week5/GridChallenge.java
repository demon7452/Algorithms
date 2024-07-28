package org.hacker.week5;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class GridChallenge {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine().trim());
        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<String> grid = IntStream.range(0, n).mapToObj(i -> {
                            try {
                                return bufferedReader.readLine();
                            } catch (IOException ex) {
                                throw new RuntimeException(ex);
                            }
                        })
                        .collect(toList());

                String result = gridChallenge(grid);

            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        bufferedReader.close();
    }

    public static String gridChallenge(List<String> grid) {
        // Write your code here
        int row = grid.size();
        int col = grid.get(0).length();
        char[][] result = new char[row][col];
        for (int i = 0; i < row; i++) {
            char[] current = grid.get(i).toCharArray();
            Arrays.sort(current);
            System.arraycopy(current, 0, result[i], 0, current.length);
            if (i > 0) {
                for (int k = 0; k < col; k++) {
                    if (result[i][k] < result[i-1][k]) {
                        return "NO";
                    }
                }
            }
        }
        return "YES";
    }


}
