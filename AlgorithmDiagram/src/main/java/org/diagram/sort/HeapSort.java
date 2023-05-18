package org.diagram.sort;

/**
 * <a href="https://www.runoob.com/w3cnote/heap-sort.html">...</a>
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] numbers = new int[]{3,2,1,6,5,4,0};
        heapSort(numbers);
        for (int number : numbers) {
            System.out.print(number + "  ");
        }
    }

    private static void heapSort(int[] numbers){
        int length = numbers.length;
        buildMaxHeap(numbers, length);
        for (int i = length - 1; i > 0; i--) {
            swap(numbers, 0, i);
            length--;
            heapIfy(numbers, 0, length);
        }
    }

    private static void buildMaxHeap(int[] numbers, int length) {
        for (int i = length / 2; i >=0; i--) {
            heapIfy(numbers, i, length);
        }
    }

    private static void heapIfy(int[] numbers, int i, int length) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        if (left < length && numbers[left] > numbers[largest]) {
            largest = left;
        }
        if (right < length && numbers[right] > numbers[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(numbers, i, largest);
            heapIfy(numbers, largest, length);
        }
    }

    private static void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
