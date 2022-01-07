package com.zrf;

import java.util.LinkedList;
import java.util.List;

public class Main118 {
    public static void main(String[] args) {
        int n = 5;
        List<List<Integer>> list = new Main118().generate(n);
    }
    private  List<List<Integer>> result = new LinkedList<>();
    public List<List<Integer>> generate(int numRows) {
        for (int i =1;i<=numRows;i++){
            processRow(i);
        }
        return result;

    }
    // 获取第n行的list
    private void processRow(int n){
        List<Integer> list = new LinkedList<>();
        if (n==1){
            list.add(1);
        }else {
            // 获取上一层的list
            List<Integer> preList = result.get(n-1);
            int index = 0;
            while (index<n){
                if (index==0 || index == n-1){
                    list.add(1);
                }else {
                    list.add(preList.get(index-1)+preList.get(index));
                }
                index++;
            }
        }
        result.add(list);
    }
}
