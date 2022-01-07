package com.zrf.binaryTree;

public class Main654 {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 6, 0, 5};
        TreeNode root = new Main654().constructMaximumBinaryTree(nums);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (null == nums || nums.length == 0) {
            return null;
        }
        return getMaxTreeNode(nums, 0, nums.length - 1);

    }

    public TreeNode getMaxTreeNode(int[] nums, int begin, int end) {

        if (begin > end) {
            return null;
        }
        int index = getMaxIndex(nums, begin, end);
        TreeNode root = new TreeNode(nums[index]);
        root.left = getMaxTreeNode(nums, begin, index - 1);
        root.right = getMaxTreeNode(nums, index + 1, end);

        return root;
    }

    public int getMaxIndex(int[] nums, int begin, int end) {
        int max = nums[begin];
        int index = begin;
        for (int i = begin; i <= end; i++) {
            if (nums[i] > max) {
                index = i;
                max = nums[i];
            }
        }
        return index;
    }
}
