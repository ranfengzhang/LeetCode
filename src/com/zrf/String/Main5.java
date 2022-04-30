package com.zrf.String;

public class Main5 {
    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(new Main5().longestPalindrome(s));
    }

    public String longestPalindrome(String s) {
        // 动态规划
        // 用f(i,j)表示从i到j（左闭右闭区间）是否是回文串
        // f(i,j) = f(i+1,j-1)^(s[i]==s[j])
        // 长度为1的都是true，从长度为2的开始遍历
        int len = s.length();
        // 默认最长长度
        int maxLen =1;
        // 默认到的结果
        String result= s.substring(0,1);
        boolean[][] dp = new boolean[len][len];
        // 长度为1的子串初始化为true
        for (int i =0;i<len;i++){
            dp[i][i] = true;
        }
        // 从长度为2的子串开始遍历
        for (int l = 2;l<=len;l++){
            for (int i = 0;i<len;i++){
                // 结尾端点
                int j = i+l-1;
                if (j>=len){
                    break;
                }
                // 怎么样结果就为false
                if (s.charAt(i)!=s.charAt(j)){
                    dp[i][j] = false;
                }else {
                    if (i+1>j-1){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }

                }

                // 更新结果
                if (dp[i][j] && l>maxLen){
                    result = s.substring(i,j+1);
                }
            }
        }
        return result;
    }
}
