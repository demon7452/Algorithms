package org.diagram.sort;

/**
 * <a href="https://www.runoob.com/w3cnote/radix-sort.html">...</a>
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] numbers = new int[]{113,87,26,35,14,13,12,11,18,39,15,11,22,65,22,78,26,66,99,10};
        radixSort(numbers);
        for (int number : numbers) {
            System.out.print(number + "  ");
        }
    }

    private static void radixSort(int[] numbers) {
        int maxValue = CountingSort.getMaxMinValue(numbers).getKey();
        int length = 0;
        if (maxValue == 0) {
            length = 1;
        } else {
            for (long temp = maxValue; temp != 0; temp /= 10) {
                length++;
            }
        }

        int mod = 10;
        int dev = 1;

        for (int i = 0; i < length; i++, dev *= 10, mod *= 10) {
            // 考虑负数的情况，这里扩展一倍队列数，其中 [0-9]对应负数，[10-19]对应正数 (bucket + 10)
            int[][] counter = new int[mod * 2][0];

            for (int number : numbers) {
                int bucket = ((number % mod) / dev) + mod;
                counter[bucket] = BucketSort.arrAppend(counter[bucket], number);
            }

            int pos = 0;
            for (int[] bucket : counter) {
                for (int value : bucket) {
                    numbers[pos++] = value;
                }
            }
        }
    }
}
