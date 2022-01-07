package com.zrf.linkedList;

public class Main206 {
    public static void main(String[] args) {
        ListNode n5 = new ListNode(5, null);
        ListNode n4 = new ListNode(4, n5);
        ListNode n3 = new ListNode(3, n4);
        ListNode n2 = new ListNode(2, n3);
        ListNode n1 = new ListNode(1, n2);
        ListNode result = new Main206().reverseList(n1);
    }

    public ListNode reverseList(ListNode head) {
        // 当链表只有一个或0个节点时，直接返回head
        if (null == head || null == head.next) {
            return head;
        }
        ListNode currentNode = head.next;
        // 将head后的每一个节点移到head前面
        while (currentNode != null) {
            ListNode nextNode = currentNode.next;
            head.next = nextNode;
            currentNode.next = head;
            head = currentNode;
            // 当前要处理的节点变为下个节点
            currentNode = nextNode;
        }
        return head;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}