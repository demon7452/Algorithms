package cn.leetcode.arrayAndString;

public class SeparateNumbers {

    public static void separateNumbers(String s) {
        // Write your code here
        boolean isBeautiful = false;
        long firstNumber = 0L;
        for (int i = 1; i <= s.length() / 2; i++) {
            firstNumber = Long.parseLong(s.substring(0, i));
            isBeautiful = isBeautiful(firstNumber, s);
            if (isBeautiful) {
                break;
            }
        }
        if (isBeautiful) {
            System.out.println("YES " + firstNumber);
        } else {
            System.out.println("NO");
        }
    }

    private static boolean isBeautiful(long firstNumber, String str) {
        StringBuilder beautifulBuilder = new StringBuilder();
        beautifulBuilder.append(firstNumber);
        long nextNumber = firstNumber + 1;
        while (beautifulBuilder.length() < str.length()
                && str.startsWith(beautifulBuilder.toString())) {
            beautifulBuilder.append(nextNumber);
            nextNumber++;
        }
        return str.equals(beautifulBuilder.toString());
    }

    public static void main(String[] args) {
        separateNumbers("00000000000000000000000000000000");
        separateNumbers("11111111111111111111111111111111");
        separateNumbers("88888888888888888888888888888888");
        separateNumbers("99100");
    }
}
