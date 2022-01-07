package com.zrf;

public class Main125 {
    public static void main(String[] args) {
        String s = "0P";
        System.out.println(new Main125().isPalindrome(s));
    }
    public boolean isPalindrome(String s) {
        // 1、将字符串转换成小写
        String t = s.toLowerCase();
        // 2、双指针
        int i = 0;
        int j = t.length()-1;
        while (i<j){
            char c1 = t.charAt(i);
            char c2 = t.charAt(j);
            if (!judgeCharacter(c1)){
                i++;
            }
            if (!judgeCharacter(c2)){
                j--;
            }
            if (judgeCharacter(c1) && judgeCharacter(c2)){
                int temp1 = c1-'a';
                int temp2 = c2- 'a';
                if (c1-'a'!=c2-'a'){
                    return false;
                }else {
                    i++;
                    j--;
                }
            }

        }
        return true;
    }
    private boolean judgeCharacter(char c){
        if (c>='a' && c<='z'){
            return true;
        }
        return false;
    }
}
