package com.zrf.binaryTree;


public class Main226 {
    public static void main(String[] args) {
        TreeNode t4 = new TreeNode(4, null, null);
        TreeNode t5 = new TreeNode(5, null, null);
        TreeNode t6 = new TreeNode(6, null, null);
        TreeNode t7 = new TreeNode(7, null, null);
        TreeNode t2 = new TreeNode(2, t4, t5);
        TreeNode t3 = new TreeNode(3, t6, t7);
        TreeNode t1 = new TreeNode(1, t2, t3);
        TreeNode root = new Main226().invertTree(t1);

    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        //先递归反转左子节点
        TreeNode left = invertTree(root.left);
        //再反转右左子节点
        TreeNode right = invertTree(root.right);
        //交换左右节点
        root.left = right;
        root.right = left;
        return root;

    }


}
