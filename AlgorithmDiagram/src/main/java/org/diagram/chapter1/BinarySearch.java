package org.diagram.chapter1;

import java.util.Arrays;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);
        getIndex(numbers, 2);
    }

    private static int getIndex(List<Integer> numbers, int target) {
        int low = 0;
        int high = numbers.size() -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target == numbers.get(mid)) {
                return mid;
            }else if (target < numbers.get(mid)) {
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
