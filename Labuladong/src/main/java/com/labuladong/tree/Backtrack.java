package com.labuladong.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Backtrack {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5};
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used);
        System.out.println(result.size());
    }

    private static List<List<Integer>> result = new ArrayList<>();
    private static LinkedList<Integer> track = new LinkedList<>();
    private static void backtrack(int[] nums, boolean[] used) {
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            track.add(nums[i]);
            used[i] = true;
            if (track.size() == nums.length) {
                result.add(new ArrayList<>(track));
            }
            backtrack(nums, used);
            track.removeLast();
            used[i] = false;
        }
    }

}
