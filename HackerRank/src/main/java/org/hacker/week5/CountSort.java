package org.hacker.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class CountSort {

    public static void main2(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<String>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                arr.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        countSort(arr);
        bufferedReader.close();
    }
    public static void countSort(List<List<String>> arr) {
        int dashIndex = arr.size();
        TreeMap<Integer, List<String>> numToStrMap = new TreeMap<>();
        for (int i = 0; i < arr.size(); i++) {
            int key = Integer.parseInt(arr.get(i).get(0));
            String str = i < dashIndex / 2 ? "-" : arr.get(i).get(1);
            if (numToStrMap.containsKey(key)) {
                numToStrMap.get(key).add(str);
            } else {
                List<String> strs = new ArrayList<>();
                strs.add(str);
                numToStrMap.put(key, strs);
            }
        }
        StringBuilder result = new StringBuilder();
        for (List<String> stringList : numToStrMap.values()) {
            result.append(String.join(" ", stringList));
            result.append(" ");
        }
        System.out.println(result);
    }

    public static void main(String[] args) {
        List<List<String>> arr = new ArrayList<>(20);
        arr.add(Arrays.asList("0","ab"));
        arr.add(Arrays.asList("6","cd"));
        arr.add(Arrays.asList("0","ef"));
        arr.add(Arrays.asList("6","gh"));
        arr.add(Arrays.asList("4", "ij"));
        arr.add(Arrays.asList("0", "ab"));
        arr.add(Arrays.asList("6", "cd"));
        arr.add(Arrays.asList("0", "ef"));
        arr.add(Arrays.asList("6", "gh"));
        arr.add(Arrays.asList("0", "ij"));
        arr.add(Arrays.asList("4", "that"));
        arr.add(Arrays.asList("3", "be"));
        arr.add(Arrays.asList("0", "to"));
        arr.add(Arrays.asList("1","be"));
        arr.add(Arrays.asList("5", "question"));
        arr.add(Arrays.asList("1", "or"));
        arr.add(Arrays.asList("2","not"));
        arr.add(Arrays.asList("4", "is"));
        arr.add(Arrays.asList("2", "to"));
        arr.add(Arrays.asList("4", "the"));
        System.out.println(arr);
        countSort(arr);
    }

    public static void countSortWithDash(List<String> arr) {
        int n = arr.size();
        int dashIndex = n / 2;

        // 创建一个Map来存储每个整数关联的字符串的原始顺序
        Map<Integer, List<String>> integerToStringMap = new HashMap<>();

        // 创建一个数组来统计每个整数的出现次数
        int[] count = new int[10001]; // 假设整数范围从0到10000

        // 统计每个整数的出现次数，并存储字符串的原始顺序
        for (int i = 0; i < n; i++) {
            String str = arr.get(i);
            int value = 0;
            if (!str.equals("-")) {
                value = Integer.parseInt(str);
            }
            count[value]++;
            List<String> strings = integerToStringMap.getOrDefault(value, new ArrayList<>());
            strings.add(str);
            integerToStringMap.put(value, strings);
        }

        // 修改数组，将前半部分的字符串替换为短横线
        for (int i = 0; i < dashIndex; i++) {
            arr.set(i, "-");
        }

        // 根据计数数组对数组进行排序
        int idx = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                List<String> strings = integerToStringMap.get(i);
                for (String str : strings) {
                    arr.set(idx, str);
                    idx++;
                }
                count[i]--;
            }
        }
    }
}
