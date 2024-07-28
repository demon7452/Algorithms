package com.labuladong.tree;

import com.labuladong.common.Data;
import com.labuladong.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelTraverse {

    public static void main(String[] args) {
        TreeNode root = Data.perfectFullTree(new int[]{1,3,2,5,4,8,7});
        List<Integer> result = levelTraverse(root);

        System.out.println(result);
    }

    private static List<Integer> levelTraverse(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                result.add(cur.val);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
        return result;
    }
}
