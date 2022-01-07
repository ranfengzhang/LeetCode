package com.zrf;

public class Main198 {
    public static void main(String[] args) {
        int[] nums = new int[]{2,1,1,2};
        System.out.println(new Main198().rob(nums));
    }

    public int rob(int[] nums) {
        // 假设f(i)为偷到第i间屋子获得的最大值
        //f(i) = max(f(i-2)+nums[i],f(i-1))
        if (nums.length == 1){
            return nums[0];
        }
        int[] temp = new int[nums.length];
        int result = Math.max(temp[0],temp[1]);
        temp[0] = nums[0];
        temp[1] = result;

        for (int i = 2;i<nums.length;i++){
            // 迭代
            temp[i] = Math.max(temp[i-2]+nums[i],temp[i-1]);
            result = Math.max(result,temp[i]);
        }
        return result;
    }
}
