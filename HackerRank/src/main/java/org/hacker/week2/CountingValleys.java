package org.hacker.week2;

public class CountingValleys {
    public static void main(String[] args) {
        System.out.println(countingValleys(8, "UDDDUDUU"));
    }

    public static int countingValleys(int steps, String path) {
        // Write your code here
        int count = 0;
        int sum = 0;
        for (char action : path.toCharArray()) {
            int current = sum;
            if ('U' == action) {
                sum++;
            } else {
                sum--;
            }
            if (current < 0 && sum == 0) {
                count++;
            }
        }
        return count;
    }
}
