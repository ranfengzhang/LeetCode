package com.zrf;

public class Main108 {
    public static void main(String[] args) {
        int[] nums = new int[]{-10,-3,0,5,9};
        new Main108().sortedArrayToBST(nums);
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        // 分治的思想
        return sortedArrayToBST(nums,0,nums.length-1);
    }
    private TreeNode sortedArrayToBST(int[] nums,int start,int end){
        if (start>end){
            return null;
        }
        int mid = (start+end)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums,start,mid-1);
        root.right = sortedArrayToBST(nums,mid+1,end);
        return root;
    }
}
 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
  }
