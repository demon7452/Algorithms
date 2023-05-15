package org.hacker.week3;

import java.util.*;

public class MigratoryBirds {
    public static void main(String[] args) {
        System.out.println(migratoryBirds(Arrays.asList(3,3,1,1,2,2,3)));
    }

    public static int migratoryBirds(List<Integer> arr) {
        // Write your code here
        Map<Integer, Integer> idToCountMap = new HashMap<>();
        arr.forEach(key -> idToCountMap.put(key, idToCountMap.getOrDefault(key, 0) + 1));
        TreeSet<Integer> maxIds = new TreeSet<>();
        int maxCount = 0;
        for (Map.Entry<Integer, Integer> entry : idToCountMap.entrySet()) {
            if(entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxIds.clear();
                maxIds.add(entry.getKey());
            }else if (entry.getValue() == maxCount) {
                maxIds.add(entry.getKey());
            }
        }
        return maxIds.first();
    }
}
