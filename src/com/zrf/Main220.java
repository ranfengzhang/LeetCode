package com.zrf;

import java.util.Arrays;

public class Main220 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1};
        int k = 3;
        int t = 0;
        System.out.println(new Main220().containsNearbyAlmostDuplicate(nums,k,t));
    }

    private TreeNode root;
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // 建立二叉搜索树
        for (int i = 0;i<nums.length;i++){
            root = insert(root,nums[i],i);
        }
        return containsNearbyAlmostDuplicate(root,k,t);
    }

    private boolean containsNearbyAlmostDuplicate(TreeNode root,int k ,int t){
        if (null == root){
            return false;
        }
        if (root.left!=null){
            if (match(root,root.left,k,t)){
                return true;
            }
        }
        if (root.right!=null){
            if (match(root,root.right,k,t)){
                return true;
            }
        }
        return containsNearbyAlmostDuplicate(root.left,k,t)||containsNearbyAlmostDuplicate(root.right,k,t);
    }

    private boolean match(TreeNode node1,TreeNode node2,int k,int t){
        // 用long，避免溢出
        long num1 = Math.abs(node1.val-node2.val);
        long num2 = Math.abs(node1.index-node2.index);
        if (num1<=t && num2<=k){
            return true;
        }
        return false;
    }

    private TreeNode insert(TreeNode root,int val,int index){
        if (null == root){
            return new TreeNode(val,index,null,null);
        }
        if (val>=root.val){
            root.right = insert(root.right,val,index);
        }else {
            root.left = insert(root.left,val,index);
        }
        return root;
    }

    private class TreeNode{
        int val;
        int index;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val,int index,TreeNode left,TreeNode right){
            this.val =val;
            this.index= index;
            this.left = left;
            this.right =right;
        }
    }
}
