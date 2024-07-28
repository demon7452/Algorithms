package org.hacker.week4;

public class Kangaroo {
    public static void main(String[] args) {

    }

    public static String kangaroo(int x1, int v1, int x2, int v2) {
        // Write your code here\
        int sub = x2 - x1;
        if (v1 <= v2) {
            return "NO";
        }
        int step = v1- v2;
        return sub % step == 0 ? "YES" : "NO";
    }
}
