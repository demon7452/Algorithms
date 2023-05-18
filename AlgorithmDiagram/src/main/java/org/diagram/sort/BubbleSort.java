package org.diagram.sort;

import java.util.List;

/**
 * <a href="https://www.runoob.com/w3cnote/bubble-sort.html">...</a>
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] numbers = new int[]{6,5,4,3,2,1};
        bubbleSort(numbers);
        for (int number : numbers) {
            System.out.print(number + "  ");
        }
    }
    private static void bubbleSort(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            boolean sorted = true;
            for (int j = 0; j < numbers.length - i; j++) {
                if (numbers[j] > numbers[j+1]) {
                    int temp =  numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = temp;
                    sorted = false;
                }
            }
            if (sorted) {
                break;
            }
        }
    }
}
