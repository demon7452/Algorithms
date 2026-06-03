package com.labuladong.backtrack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SubSets {
    public static void main(String[] args) {
        SubSets subSets = new SubSets();
        subSets.subsets(new int[]{0});
    }


    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        for (int num : nums) {
            arr.add(num);
        }
        Collections.sort(arr);
        for (int i = 0; i <= nums.length; i++) {
            LinkedList<Integer> track = new LinkedList<>();
            build(arr, track, i);
        }
        return result;
    }

    private void build(List<Integer> arr, LinkedList<Integer> track, int target) {
        if (track.size() == target) {
            result.add(new ArrayList<>(track));
            return;
        }
        for (int i = 0; i < arr.size(); i++) {
            if (!track.isEmpty() && arr.get(i) <= track.getLast()) {
                continue;
            }
            int remove = arr.remove(i);
            track.add(remove);

            build(arr, track, target);

            track.removeLast();
            arr.add(i, remove);
        }
    }

}
