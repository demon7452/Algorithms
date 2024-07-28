package com.labuladong.common;

import java.util.LinkedList;
import java.util.Queue;

public class Data {

    public static void main(String[] args) {
    }

    public static TreeNode perfectFullTree(int[] nums) {
        return buildTree(nums);
    }

    private static TreeNode buildTree(int[] nums){
        TreeNode root = new TreeNode(-1);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 1;
        for (int num : nums) {
            TreeNode cur = queue.poll();
            cur.val = num;
            if (count < nums.length) {
                TreeNode left = new TreeNode(-1);
                cur.left = left;
                queue.offer(left);
                count++;
            }
            if (count < nums.length) {
                TreeNode right = new TreeNode(-1);
                cur.right = right;
                queue.offer(right);
                count++;
            }
        }
        return root;
    }
}
