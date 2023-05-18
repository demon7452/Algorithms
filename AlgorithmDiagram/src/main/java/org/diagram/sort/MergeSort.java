package org.diagram.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Arrays.sort;

/**
 * <a href="https://www.runoob.com/w3cnote/merge-sort.html">...</a>
 */
public class MergeSort {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(7,6,5,4,3,2,1,8,9,15,11,22,65,32,78,26,66,99,0);
        numbers = mergeSort(numbers);
        for (int number : numbers) {
            System.out.print(number + "  ");
        }
    }

    private static List<Integer> mergeSort(List<Integer> numbers){
        int size = numbers.size();
        if (size <= 1) {
            return numbers;
        }
        int middleIndex = size / 2;
        List<Integer> left = numbers.subList(0, middleIndex);
        List<Integer> right = numbers.subList(middleIndex, size);
        return merge(mergeSort(left), mergeSort(right));
    }

    private static List<Integer> merge(List<Integer> left, List<Integer> right){
        List<Integer> result = new ArrayList<>(left.size() + right.size());
        int i = 0, j = 0;
        while (left.size() > i && right.size() > j) {
            if (left.get(i) < right.get(j)) {
                result.add(right.get(j));
                j++;
            }else {
                result.add(left.get(i));
                i++;
            }
        }
        if (i != left.size()) {
            result.addAll(left.subList(i, left.size()));
        }
        if (j != right.size()) {
            result.addAll(right.subList(j, right.size()));
        }
        return result;
    }
}
