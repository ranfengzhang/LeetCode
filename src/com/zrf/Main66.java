package com.zrf;

import java.util.Arrays;

public class Main66 {
    public static void main(String[] args) {
        int[] digits = new int[]{9,8,7,6,5,4,3,2,1,0};
        int[] result = new Main66().plusOne(digits);
        System.out.println(Arrays.toString(result));
    }
    public int[] plusOne(int[] digits) {
        // 组装数字
        long sum = 0;
        for (int i = 0;i<digits.length;i++){
            sum = 10*sum+digits[i];
        }
        sum++;
        // 恢复成数组
        String str = String.valueOf(sum);
        int size = str.length();
        int[] result = new int[size];
        for (int i = size-1;i>=0;i--){
            result[i] = (int)(sum%10);
            sum = sum/10;
        }
        return result;
    }
}
