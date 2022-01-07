package com.zrf;

import java.util.Arrays;

public class Main283 {
    public static void main(String[] args) {
        int[] arrs = new int[]{4,2,4,0,0,3,0,5,1,0};
        new Main283().moveZeroes(arrs);
        System.out.println(Arrays.toString(arrs));
    }
    public void moveZeroes(int[] nums) {
        // 类似删除数组中重复项，双指针
        int p = 0;
        int q = 0;
        // 需要从前往后遍历，假设p为0的下标，q为非0的下标
        while (p<nums.length){
            // p移到一个下标为0的数字
            if (nums[p]==0){
                // q从p开始找到一个下标为1的数字
                q = p;
                while (q<nums.length){
                    if (nums[q]!=0){
                        break;
                    }
                    q++;
                }
                if (q==nums.length){
                    break;
                }
                swap(nums,p,q);
            }
            p++;


        }
    }
    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
