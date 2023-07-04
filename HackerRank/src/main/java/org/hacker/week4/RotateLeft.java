package org.hacker.week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotateLeft {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5);
        System.out.println(rotateLeft(54, arr));
    }

    public static List<Integer> rotateLeft(int d, List<Integer> arr) {
        d = d % arr.size();
        if (d == 0) {
            return arr;
        }
        List<Integer> tail = new ArrayList<>(d);
        List<Integer> head = new ArrayList<>(arr.size());
        for (int i = 0; i < arr.size(); i++) {
            if (i < d) {
                tail.add(arr.get(i));
            } else {
                head.add(arr.get(i));
            }
        }
        head.addAll(tail);
        return head;
    }
}
