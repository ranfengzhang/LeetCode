package com.zrf.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main114 {
    public static void main(String[] args) {
        TreeNode t3 = new TreeNode(3, null, null);
        TreeNode t4 = new TreeNode(4, null, null);
        TreeNode t6 = new TreeNode(6, null, null);
        TreeNode t2 = new TreeNode(2, t3, t4);
        TreeNode t5 = new TreeNode(5, null, t6);
        TreeNode t1 = new TreeNode(1, t2, t5);
        new Main114().flatten1(t1);
    }

    public void flatten(TreeNode root) {
        //获取前序遍历的列表
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (null != node) {
                list.add(node.data);
                stack.push(node.right);
                stack.push(node.left);
            }
        }

        TreeNode node = root;
        for (int i = 0; i < list.size() - 1; i++) {
            node.data = list.get(i);
            node.left = null;
            node.right = new TreeNode();
            node = node.right;
        }

    }

    /**
     * 递归法
     *
     * @param root
     */
    public void flatten1(TreeNode root) {
        //1、为null，直接返回
        if (null == root) {
            return;
        }
        //2、递归展开链表
        swapTreeToList(root);
    }

    private void swapTreeToList(TreeNode root) {
        if (null != root) {
            //展开左子树
            swapTreeToList(root.left);
            //展开右子树
            swapTreeToList(root.right);
            TreeNode leftNode = root.left;
            TreeNode rightNode = root.right;
            //如果左子树不为空，root的right指向left
            //left的最右节点的right指向原有的right
            if (null != leftNode) {
                root.left = null;
                root.right = leftNode;
                TreeNode tempNode = leftNode;
                //找到左子树的最末端节点
                while (tempNode.right != null) {
                    tempNode = tempNode.right;
                }
                tempNode.right = rightNode;
                leftNode.left = null;
            }

        }
        return;
    }
}
