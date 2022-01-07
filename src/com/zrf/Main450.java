package com.zrf;

import com.zrf.binaryTree.Main105;


public class Main450 {
    private  class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this(val,null,null);
        }
        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String[] args) {
        int[] preorder = new int[]{5,3,2,4,6,7};
        int[] inorder = new int[]{2,3,4,5,6,7};
        TreeNode root = new Main450().buildTree(preorder,inorder);
        int key = 3;
        TreeNode node = new Main450().deleteNode(root,key);
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (null == root){
            return root;
        }
        TreeNode prevNode = null;
        TreeNode currNode = root;
        while (currNode!=null){

            if (currNode.val == key){
                // 判断currNode的子节点情况
                //1、没有子节点
                if (null== currNode.left && null==currNode.right){
                    currNode = null;
                }else if (null == currNode.left){
                    //2、有一个子节点，2.1 左子节点为空
                    currNode = currNode.right;
                }else if (null == currNode.right){
                    //2.2 右子节点为空
                    currNode = currNode.left;
                }else {
                    //3、两个子节点，找到currNode的中序的前驱或后继节点，与currNode替换
                    // 即要找左子树的最右节点或右子树的最左节点
                    TreeNode tempPrev = currNode;
                    TreeNode tempCurr = currNode.left;
                    while (tempCurr.left!=null || tempCurr.right!=null){
                        tempPrev = tempCurr;
                        if (tempCurr.right!=null){
                            tempCurr = tempCurr.right;
                        }else {
                            tempCurr = tempCurr.left;
                        }
                    }
                    // 最终找到了tempCurr,与currNode交换
                    currNode.val = tempCurr.val;
                    if (tempPrev.left == tempCurr){
                        tempPrev.left = null;
                    }else {
                        tempPrev.right = null;
                    }
                }
                break;
            }else if (currNode.val <key){
                prevNode = currNode;
                currNode = currNode.right;
            }else {
                prevNode = currNode;
                currNode = currNode.left;
            }
        }
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(null==preorder || null==inorder||preorder.length==0||inorder.length==0){
            return null;
        }
        return getTree(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    public TreeNode getTree(int[] preorder, int begin1, int end1, int[] inorder, int begin2, int end2){
        if(begin1>end1||begin2>end2){
            return null;
        }
        int index = getIndex(inorder,begin2,end2,preorder[begin1]);
        TreeNode root = new TreeNode(preorder[begin1]);
        int leftLen = index-begin2;
        int rightLen = end2-index;
        root.left = getTree(preorder,begin1+1,begin1+leftLen,inorder,begin2,index-1);
        root.right = getTree(preorder,end1-rightLen+1,end1,inorder,index+1,end2);
        return root;
    }

    public int getIndex(int[] nums ,int begin,int end,int target){
        int result = begin;
        for(int i = begin;i<=end;i++){
            if(nums[i]==target){
                result = i;
                break;
            }
        }
        return result;
    }
}

