package org.hacker.week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetTotalX {
    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(2, 4);
        List<Integer> b = Arrays.asList(16, 32, 96);
        System.out.println(getTotalX2(a, b));
    }

    public static int getTotalX(List<Integer> a, List<Integer> b) {
        int start = a.get(a.size() -1);
        int end = b.get(0);
        int first = -1;
        for (int i = start; i <= end ; i++) {
            if (isDivide(a, i) && isBeDivide(b, i)) {
                first = i;
                break;
            }
        }
        if (first == -1) {
            return 0;
        }
        List<Integer> all = new ArrayList<>();
        int multiple = 1;
        int result = first;
        while (result <= end){
            all.add(result);
            multiple++;
            result = first * multiple;
        }
        int count = 1;
        for (int i = 1; i < all.size(); i++) {
            if (isDivide(a, all.get(i)) && isBeDivide(b, all.get(i))) {
                count++;
            }
        }
        return count;
    }

    private static int getTotalX2(List<Integer> a, List<Integer> b) {
        // 计算列表 a 的最小公倍数
        int lcmA = a.get(0);
        for (int i = 1; i < a.size(); i++) {
            lcmA = lcm(lcmA, a.get(i));
        }

        // 求b的最大公约数
        int gcdB = b.get(0);
        for (int i = 1; i < b.size(); i++) {
            gcdB = gcd(gcdB, b.get(i));
        }

        int count = 0;
        // 检查最大公约数的倍数是否能被最小公倍数整除
        for (int i = lcmA; i <= gcdB; i += lcmA) {
            if (gcdB % i == 0) {
                count++;
            }
        }
        return count;
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    // 计算最小公倍数的函数
    private static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    private static boolean isDivide(List<Integer> a, int divide) {
        for (Integer num : a) {
            if (divide % num != 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isBeDivide(List<Integer> b, int divide) {
        for (Integer num : b) {
            if (num % divide  != 0) {
                return false;
            }
        }
        return true;
    }
}
