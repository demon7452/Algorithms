package org.hacker.week3;

import java.util.*;

public class SockMerchant {

    public static void main(String[] args) {
        System.out.println(sockMerchant(9, Arrays.asList(10, 20, 20, 10, 10, 30, 50, 10, 20)));
    }
    public static int sockMerchant(int n, List<Integer> ar) {
        // Write your code here
        Set<Integer> socksSet = new HashSet<>();
        int pairs = 0;
        for (Integer sockNum : ar) {
            if (socksSet.contains(sockNum)) {
                pairs++;
                socksSet.remove(sockNum);
            }else {
                socksSet.add(sockNum);
            }
        }
        return pairs;
    }
}
