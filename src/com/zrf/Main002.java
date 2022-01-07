package com.zrf;

public class Main002 {
    public static void main(String[] args) {
        ListNode l13 = new ListNode(3,null);
        ListNode l12 = new ListNode(4,l13);
        ListNode l11 = new ListNode(2,l12);
        ListNode l23 = new ListNode(4,null);
        ListNode l22 = new ListNode(6,l23);
        ListNode l21 = new ListNode(5,l22);
        ListNode l = addTwoNumbers1(l11,l21);

    }
    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode l = new ListNode();
        ListNode currNode = l;
        if(l1 == null || l2==null){
            return null;
        }
        int temp = 0;
        int v1 = 0;
        int v2 = 0;
        while(l1!=null || l2!=null){
            ListNode nextNode = new ListNode();
            if (l1 == null){
                v1 = 0;
            }else {
                v1 = l1.val;
                l1 = l1.next;
            }
            if (l2 == null){
                v2 = 0;
            }else {
                v2 = l2.val;
                l2 = l2.next;
            }
            currNode.val = (v1+v2+temp)%10;
            temp = (v1+v2+temp)/10;
            if (l1 !=null || l2!=null){
                currNode.next = nextNode;
                currNode = nextNode;
            }

        }
        if (temp!=0){
            currNode.next =new ListNode(temp);
        }
        return l;
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
