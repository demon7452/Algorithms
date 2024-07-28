package org.hacker.week5;

import java.util.Scanner;

public class TestSmartNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        for (int i = 0; i < count; i++) {
            int number = scanner.nextInt();
            double half = Math.sqrt(number);
            if (half - (int)half == 0) {
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }
}
