package com.zrf;

import java.util.LinkedList;
import java.util.List;

public class Main155 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}
class MinStack{
    private LinkedList<Integer> list;
    private int min;
    public MinStack() {
        this.list = new LinkedList<>();
        this.min = 0;
    }

    public void push(int val) {
        list.offerLast(val);
        min = Math.min(val,min);
    }

    public void pop() {
        list.removeLast();
        for (int i = 0;i<list.size();i++){
            if (min>list.get(i)){
                min = list.get(i);
            }
        }
    }

    public int top() {
        return list.get(list.size()-1);
    }

    public int getMin() {
        return min;
    }
}
