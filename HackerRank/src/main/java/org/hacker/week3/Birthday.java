package org.hacker.week3;

import java.util.Arrays;
import java.util.List;

public class Birthday {
    public static void main(String[] args) {
        List<Integer> s = Arrays.asList(2,2,1,3,2);
        System.out.println(birthday(s, 4, 2));
    }

    /**
     * 使用滑动窗口的方法
     */
    public static int birthday(List<Integer> s, int d, int m) {
        // Write your code here
        int count = 0;
        int sum = 0;
        for (int i = 0; i < s.size(); i++) {
            sum += s.get(i);
            if (i >= m) {
                sum -= s.get(i - m);
            }
            if (i >= m - 1 && sum == d) {
                count++;
            }
        }
        return count;
    }
}
