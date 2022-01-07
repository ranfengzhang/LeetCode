package com.zrf.binaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main652 {

    private HashMap<String, Integer> map = new HashMap<>();
    private HashMap<Integer, Integer> countMap = new HashMap<>();
    private List<TreeNode> list = new ArrayList<>();
    private Integer count = 0;
    private Integer i = 1;

    public static void main(String[] args) {
//        TreeNode t7= new TreeNode(4,null,null);
//        TreeNode t4 = new TreeNode(4,null,null);
//        TreeNode t5 = new TreeNode(2,t7,null);
//        TreeNode t6 = new TreeNode(4,null,null);
//        TreeNode t2 = new TreeNode(2,t4,null);
//        TreeNode t3 = new TreeNode(3,t5,t6);
//        TreeNode t1 = new TreeNode(1,t2,t3);
//        List<TreeNode> list = new Main652().findDuplicateSubtrees(t1);
        TreeNode t6 = new TreeNode(0, null, null);
        TreeNode t4 = new TreeNode(0, null, null);
        TreeNode t5 = new TreeNode(0, null, t6);
        TreeNode t2 = new TreeNode(0, t4, null);
        TreeNode t3 = new TreeNode(0, null, t5);
        TreeNode t1 = new TreeNode(0, t2, t3);
        List<TreeNode> list = new Main652().findDuplicateSubtrees(t1);
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        //先序遍历，将map的每个节点转化成一个字符串，k为节点的值，v为节点对应的字符串
        //记录下对应值的次数
        //list存放最终结果，如果等于两次以上，则list记录最终结果，null可以用#表示
        preorder2(root);
        return list;
    }

    private String preorder(TreeNode root) {
        if (null == root) {
            return "#";
        }
        String str = root.data + "," + preorder(root.left) + "," + preorder(root.right);
        map.put(str, map.getOrDefault(str, count) + 1);
        if (map.get(str) == 2) {
            list.add(root);
        }

        return str;
    }

    private int preorder2(TreeNode root) {
        if (null == root) {
            return 0;
        }
        String str = root.data + "," + preorder2(root.left) + "," + preorder2(root.right);
        int uid = map.computeIfAbsent(str, x -> i++);
//        int uid ;
//        if(!map.containsKey(str)){
//            uid = i;
//            map.put(str,i++);
//        }else{
//            uid = map.get(str);
//        }
        countMap.put(uid, countMap.getOrDefault(uid, 0) + 1);
        if (countMap.get(uid) == 2) {
            list.add(root);
        }
        return uid;

    }
}
