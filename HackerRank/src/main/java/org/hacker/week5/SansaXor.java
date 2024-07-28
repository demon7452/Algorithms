package org.hacker.week5;

import java.util.List;

public class SansaXor {
    public static void main(String[] args) {
        System.out.println(1 ^ 2 ^ 4);
        System.out.println(1 ^ 2);
        System.out.println(2 ^ 4);
        System.out.println(3 ^ 6);
        System.out.println(1 ^ 4);
        System.out.println(1 ^ 2 ^ 3);
    }
    public static int sansaXor(List<Integer> arr) {
        int n = arr.size();
        if (n % 2 == 0) {
            return 0; // 如果数组长度为偶数，结果为0
        } else {
            int result = 0;
            for (int i = 0; i < n; i += 2) {
                result ^= arr.get(i); // 对每个奇数索引位置的元素进行异或操作
            }
            return result;
        }
    }
}
