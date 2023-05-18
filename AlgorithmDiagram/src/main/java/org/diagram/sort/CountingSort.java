package org.diagram.sort;

import javafx.util.Pair;

/**
 * <a href="https://www.runoob.com/w3cnote/counting-sort.html">...</a>
 */
public class CountingSort {

    public static void main(String[] args) {
        int[] numbers = new int[]{87,26,35,14,13,12,11,18,39,15,11,22,65,22,78,26,66,99,10};
        countingSort(numbers);
        for (int number : numbers) {
            System.out.print(number + "  ");
        }
    }

    public static Pair<Integer, Integer> getMaxMinValue(int[] numbers) {
        int minValue = numbers[0];
        int maxValue = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > maxValue) {
                maxValue = numbers[i];
            }
            if (numbers[i] < minValue) {
                minValue = numbers[i];
            }
        }
        return new Pair<>(maxValue, minValue);
    }

    public static void countingSort(int[] numbers) {
        Pair<Integer, Integer> maxToMin = getMaxMinValue(numbers);
        int minValue = maxToMin.getValue();
        int maxValue = maxToMin.getKey();

        int[] countArr = new int[maxValue+1];
        for (int number : numbers) {
            countArr[number]++;
        }

        int startIndex = 0;
        for (int i = minValue; i < countArr.length; i++) {
            while (countArr[i] > 0) {
                numbers[startIndex] = i;
                startIndex++;
                countArr[i]--;
            }
        }
    }
}
