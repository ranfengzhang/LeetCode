package com.zrf.String;

import java.util.Arrays;

public class Main151 {
    public static void main(String[] args) {
        String s = "  hello  world  ";
        String[] strings = s.split(" ");
        System.out.println(Arrays.toString(strings));
    }
    public String reverseWords(String s) {
        // 总体思想是先整体翻转，再翻转其中每个字符串
        StringBuffer buffer = new StringBuffer(s);
        String reverseS = buffer.reverse().toString();
        // 逐个翻转
        StringBuffer reverseBuffer = new StringBuffer();
        // 还未添加空格
        boolean spaceFlag = false;
        for (int i = 0;i<reverseS.length();i++){
            if (reverseS.charAt(i)!=' '){
                spaceFlag = false;
                reverseBuffer.insert(0,reverseS.charAt(i));
            }else {

                if (!spaceFlag){
                    reverseBuffer.append(" ");
                }
                spaceFlag = true;
            }
        }
        return reverseBuffer.toString();
    }
}
