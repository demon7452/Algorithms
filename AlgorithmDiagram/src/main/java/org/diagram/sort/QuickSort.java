package org.diagram.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://www.runoob.com/w3cnote/quick-sort-2.html">...</a>
 */
public class QuickSort {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(7,6,5,4,3,2,1,8,9,15,11,22,65,22,78,26,66,99,0);
        numbers = quickSort(numbers);
        for (int number : numbers) {
            System.out.print(number + "  ");
        }
    }

    public static List<Integer> quickSort(List<Integer> numbers){
        if (numbers.size() <= 1) {
            return numbers;
        }
        int pivot = numbers.get(0);
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int i = 1; i < numbers.size(); i++) {
            if (pivot >= numbers.get(i)) {
                left.add(numbers.get(i));
            } else {
                right.add(numbers.get(i));
            }
        }
        List<Integer> result = new ArrayList<>(numbers.size());
        result.addAll(quickSort(left));
        result.add(pivot);
        result.addAll(quickSort(right));
        return result;
    }
}
