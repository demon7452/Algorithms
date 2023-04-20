package org.hacker.week2;

import java.util.function.LongBinaryOperator;

public class FlippingBits {
    public static void main(String[] args) {
        System.out.println(flippingBits(1));
        System.out.println(flippingBits(0));

    }

    public static long flippingBits(long n) {
        long maxUnsignedInt = (1L << 32) - 1;
        return n ^ maxUnsignedInt;
    }

    public static int reverseBits(int num) {
        int newNum = 0;
        for (int i = 0; i < 32; i++) {
            newNum |= (num & 1) ^ 1;
            if (i != 31) {
                newNum <<= 1;
                num >>= 1;
            }
        }
        return newNum;
    }

}
