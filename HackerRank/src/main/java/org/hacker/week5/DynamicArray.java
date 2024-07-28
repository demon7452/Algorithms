package org.hacker.week5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DynamicArray {
    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        // Write your code here
        int lastAnswer = 0;
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new ArrayList<>());
        }
        for (List<Integer> query : queries) {
            if (query.get(0) == 1) {
                int index = (query.get(1) ^ lastAnswer) % n;
                arr.get(index).add(query.get(2));
            } else {
                int index = (query.get(1) ^ lastAnswer) % n;
                int index2 = query.get(2) % arr.get(index).size();
                lastAnswer = arr.get(index).get(index2);
                result.add(lastAnswer);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> queries = new ArrayList<>();
        queries.add(Arrays.asList(1,0,5));
        queries.add(Arrays.asList(1,1,7));
        queries.add(Arrays.asList(1,0,3));
        queries.add(Arrays.asList(2,1,0));
        queries.add(Arrays.asList(2,1,1));
        System.out.println(dynamicArray(2, queries));
    }

}
