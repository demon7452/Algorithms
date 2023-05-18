package org.diagram.sort;

/**
 * <a href="https://www.runoob.com/w3cnote/shell-sort.html">...</a>
 * <a href="https://www.bilibili.com/video/BV1rE411g7rW/?vd_source=7885036ec8158c5b430e6dd404f557e3">...</a>
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] numbers = new int[]{7,6,5,4,3,2,1,8,9,15,11,22,65,32,78,26,66,99,0};
        insertionSortToShell(numbers);
//        shellSort(numbers);
        for (int number : numbers) {
            System.out.print(number + "  ");
        }
    }
    private static void shellSort(int[] arr) {
        int length = arr.length;
        int temp;
        for (int step = length / 2; step >= 1; step /= 2) {
            for (int i = step; i < length; i++) {
                temp = arr[i];
                int j = i - step;
                while (j >= 0 && arr[j] > temp) {
                    arr[j + step] = arr[j];
                    j -= step;
                }
                arr[j + step] = temp;
            }
        }
    }

    private static void insertionSortToShell(int[] numbers) {
        int length = numbers.length;
        for (int step = (length/3 + 1); step >=1 ; step = step /2) {
            for (int i = step; i < length; i++) {
                int temp = numbers[i];
                int j = i - step;
                while (j >= 0 && temp < numbers[j]) {
                    numbers[j + step] = numbers[j];
                    j = j - step;
                }
                if (j != i - step) {
                    numbers[j + step] = temp;
                }
            }
        }
    }

    private static void insertionSort(int[] numbers) {
        int length = numbers.length;
        for (int i = 1; i < length; i++) {
            int temp = numbers[i];
            int j = i - 1;
            while (j >= 0 && temp < numbers[j]) {
                numbers[j + 1] = numbers[j];
                j = j - 1;
            }
            if (j != i - 1) {
                numbers[j+1] = temp;
            }
        }
    }
}
