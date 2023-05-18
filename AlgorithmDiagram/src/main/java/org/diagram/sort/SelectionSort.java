package org.diagram.sort;

/**
 * <a href="https://www.runoob.com/w3cnote/selection-sort.html">...</a>
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] numbers = new int[]{6,5,4,3,2,1};
        selectionSort(numbers);
        for (int number : numbers) {
            System.out.print(number + "  ");
        }
    }

    private static void selectionSort(int[] numbers) {
        int minIndex,temp;
        for (int i = 0; i < numbers.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[minIndex] > numbers[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                temp = numbers[minIndex];
                numbers[minIndex] = numbers[i];
                numbers[i] = temp;
            }
        }
    }
}
