package com.zrf;

public class Main485 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,0,1,1,1};
        System.out.println(new Main485().findMaxConsecutiveOnes(nums));
    }
    public int findMaxConsecutiveOnes(int[] nums) {
        // 快慢指针
        int slow = 0,fast = 0;
        int max = 0;
        while (fast<nums.length){
            if (nums[fast]==0){
                max = Math.max(max,fast-slow);
                // slow先置为fast
                slow = fast;
                // slow找到下一个为1的地方
                while (nums[slow]==0){
                    slow++;
                }
                // fast从slow开始
                fast = slow;
            }else {
                fast++;
            }

        }
        max = Math.max(max,fast-slow);
        return max;
    }
}
