package com.zrf;

public class Main53 {
    public static void main(String[] args) {
        int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new Main53().maxSubArray(arr));
    }
    public int maxSubArray(int[] nums) {
        // 统计以nums中第i个元素结尾的最大值
        int[] temp = new int[nums.length];
        temp[0] = nums[0];
        for (int i = 1;i<nums.length;i++){
            temp[i] = Math.max(temp[i-1]+nums[i],nums[i]);
        }
        //返回temp中最大值
        int result = temp[0];
        for (int i = 1;i<temp.length;i++){
            if (temp[i]>result){
                result = temp[i];
            }
        }
        return result;
    }
}
