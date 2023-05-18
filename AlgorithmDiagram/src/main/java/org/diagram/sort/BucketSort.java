package org.diagram.sort;

import javafx.util.Pair;

import java.util.Arrays;

import static org.diagram.sort.CountingSort.getMaxMinValue;

/**
 * <a href="https://www.runoob.com/w3cnote/bucket-sort.html">...</a>
 */
public class BucketSort {
    public static void main(String[] args) {
        int[] numbers = new int[]{87,26,35,14,13,12,11,18,39,15,11,22,65,22,78,26,66,99,10};
        bucketSort(numbers, 10);
        for (int number : numbers) {
            System.out.print(number + "  ");
        }
    }

    private static void bucketSort(int[] numbers, int bucketSize) {
        Pair<Integer, Integer> maxToMin = getMaxMinValue(numbers);
        int minValue = maxToMin.getValue();
        int maxValue = maxToMin.getKey();

        int bucketCount = (maxValue - minValue) / bucketSize + 1;
        int[][] buckets = new int[bucketCount][0];

        // 利用映射函数将数据分配到各个桶中
        for (int number : numbers) {
            int index = (number - minValue) / bucketSize;
            buckets[index] = arrAppend(buckets[index], number);
        }
        int currentIndex = 0;
        for (int[] bucket : buckets) {
            if (bucket.length == 0) {
                continue;
            }
            CountingSort.countingSort(bucket);
            for (int num : bucket) {
                numbers[currentIndex++] = num;
            }
        }
    }

    public static int[] arrAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }
}
