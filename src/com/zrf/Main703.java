package com.zrf;

public class Main703 {
    private int k;
    private TreeNode root;

    public Main703(int k, int[] nums) {
        this.k = k;
        for (int i = 0;i<nums.length;i++){
            root = insert(root,nums[i]);
        }
    }

    private TreeNode insert(TreeNode root,int key){
        if (null == root){
            return new TreeNode(key,1,null,null);
        }
        if (key<= root.val){
            root.left = insert(root.left,key);
            root.childNums +=1;
        }else {
            root.right = insert(root.right,key);
            root.childNums +=1;
        }
        return root;
    }

    public int add(int val) {
        // 插入元素
        root = insert(root,val);
        // 获取第k大元素
        return getKthNum(root,k);
    }

    private int getKthNum(TreeNode root,int k){
        TreeNode node = root;
        // if (root==null){
        //     return 0;
        // }
        // 左子树为空，且k=childNums，返回root.val
        if (node.left == null && node.childNums == k){
            return node.val;
        }
        if (null!=node.right){
            int rightNums = node.right.childNums;
            if (k-rightNums-1==0){
                return node.val;
            }else if (k<=rightNums){
                return getKthNum(node.right,k);
            }else{
                return getKthNum(node.left,k-rightNums-1);
            }
        }else {
            // 右子树为空，
            if (k==1){
                return node.val;
            }
            return getKthNum(node.left,k-1);
        }
    }

    private class TreeNode{
        int val;
        int childNums;// 子节点+自身数目
        TreeNode left;
        TreeNode right;
        public TreeNode(int val,int childNums,TreeNode left,TreeNode right){
            this.val =val;
            this.childNums = childNums;
            this.left = left;
            this.right = right;
        }
    }
    public static void main(String[] args) {
        Main703 main703 = new Main703(1,new int[]{-2});
        System.out.println(main703.add(-3));
        System.out.println(main703.add(0));
        System.out.println(main703.add(2));
        System.out.println(main703.add(-1));
        System.out.println(main703.add(4));
    }
}
