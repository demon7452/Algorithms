package org.diagram.sort;

/**
 * <a href="https://www.runoob.com/w3cnote/insertion-sort.html">...</a>
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] numbers = new int[]{6,5,4,3,2,1};
        insertionSort(numbers);
        for (int number : numbers) {
            System.out.print(number + "  ");
        }
    }

    private static void insertionSort(int[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            int temp = numbers[i];
            int j = i;
            while (j > 0 && temp < numbers[j -1]) {
                numbers[j] = numbers[j -1];
                j--;
            }
            if (i != j) {
                numbers[j] = temp;
            }
        }
    }
}
