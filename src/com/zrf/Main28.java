package com.zrf;

public class Main28 {
    public static void main(String[] args) {
        String s = "a";
        String t = "a";
        System.out.println(new Main28().strStr(s,t));
    }
    public int strStr(String s, String t) {
        if (s.length()==0){
            return 0;
        }
        if (s.length()<t.length()){
            return -1;
        }
        int result = -1;//默认为-1
        int i = 0;
        int j = -1;
        int[] next = getNext(t);
        while (i<s.length() && j<t.length()){
            if (j==-1 ||s.charAt(i) == t.charAt(j)){
                i++;
                j++;
            }else {
                //i不变
                //j值从next[j]开始
                j = next[j];
            }
        }
        if (j==t.length()){
            result = i-j;
        }
        return result;
    }
    //最初始的KMP算法
    private int[] getNext(String t){
        int[] next = new int[t.length()];
        //前两个数一点是-1，初始化
        next[0] = -1;
        int i = 0;
        int j = -1;//代表next数组的初始值
        while(i<t.length()-1){
            if(j==-1||t.charAt(i)==t.charAt(j)){
                //如果k=-1或者当前字符匹配，则j、k都加1
                i++;
                j++;
                //next数组值等于最长匹配的前缀和后缀长度
                next[i] = j;
                //System.out.println(j+":"+next[j]);
            }else{
                //递归j=next[j];
                j = next[j];
            }
        }
        return next;
    }
}
