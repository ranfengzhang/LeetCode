package com.zrf.binaryTree;

public class Main105 {
    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        TreeNode root = new Main105().buildTree(preorder, inorder);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (null == preorder || null == inorder || preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        return getTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode getTree(int[] preorder, int begin1, int end1, int[] inorder, int begin2, int end2) {
        if (begin1 > end1 || begin2 > end2) {
            return null;
        }
        int index = getIndex(inorder, begin2, end2, preorder[begin1]);
        TreeNode root = new TreeNode(preorder[begin1]);
        int leftLen = index - begin2;
        int rightLen = end2 - index;
        root.left = getTree(preorder, begin1 + 1, begin1 + leftLen, inorder, begin2, index - 1);
        root.right = getTree(preorder, end1 - rightLen + 1, end1, inorder, index + 1, end2);
        return root;
    }

    public int getIndex(int[] nums, int begin, int end, int target) {
        int result = begin;
        for (int i = begin; i <= end; i++) {
            if (nums[i] == target) {
                result = i;
                break;
            }
        }
        return result;
    }
}
