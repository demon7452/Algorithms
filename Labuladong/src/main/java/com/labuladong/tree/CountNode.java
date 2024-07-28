package com.labuladong.tree;

import com.labuladong.common.TreeNode;

public class CountNode {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(2), new TreeNode(3, new TreeNode(5), new TreeNode(4)));

        System.out.println(countNode(root));
    }

    public static int countNode(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftCount = countNode(root.left);
        int rightCount = countNode(root.right);

        return leftCount + rightCount + 1;
    }
}
