package org.hacker.week1;

import java.util.Collections;
import java.util.List;

public class SampleTest {
    public static void main(String[] args) {
        fizzBuzz(15);
    }

    public static void fizzBuzz(int n) {
        for (int i = 1; i <= n; i++) {
            boolean multipleBy3 =  i % 3 == 0;
            boolean multipleBy5 =  i % 5 == 0;
            if (multipleBy3 && multipleBy5) {
                System.out.println("FizzBuzz");
            } else if (multipleBy3) {
                System.out.println("Fizz");
            } else if (multipleBy5) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }

    public static int findMedian(List<Integer> arr) {
        // Write your code here
        Collections.sort(arr);
        return arr.get(arr.size() / 2);
    }
}
