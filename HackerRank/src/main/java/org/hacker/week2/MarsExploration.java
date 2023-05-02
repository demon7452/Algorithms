package org.hacker.week2;

public class MarsExploration {
    public static void main(String[] args) {
        System.out.println(marsExploration("SOSSPSSQSSOR"));
        System.out.println(marsExploration("SOSSOT"));
    }

    public static int marsExploration(String s) {
        // Write your code here
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i % 3 == 0 || i % 3 == 2) {
                if (s.charAt(i) != 'S'){
                    count++;
                }
            }
            if (i % 3 == 1) {
                if (s.charAt(i) != 'O'){
                    count++;
                }
            }
        }
        return count;
    }

    public static int marsExploration2(String s) {
        int count = 0;
        for (int i = 0; i < s.length() - 2; i += 3) {
            if (s.charAt(i) != 'S') {
                count++;
            }
            if (s.charAt(i + 1) != 'O') {
                count++;
            }
            if (s.charAt(i + 2) != 'S') {
                count++;
            }
        }
        return count;
    }
}
