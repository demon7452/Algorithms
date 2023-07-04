package org.hacker.week3;

public class PageCount {
    public static void main(String[] args) {
        System.out.println(pageCount(19, 6));
    }

    public static int pageCount(int n, int p) {
        // Calculate the number of page turns from the front
        int fromFront = p / 2;

        // Calculate the number of page turns from the back
        int fromBack = (n / 2) - (p / 2);

        // Return the minimum number of page turns
        return Math.min(fromFront, fromBack);
    }
}
