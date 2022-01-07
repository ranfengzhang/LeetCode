package com.zrf;

public class Main189 {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,-100,3,99};
        int k = 2;
        new Main189().rotate(nums,k);
    }
    public void rotate(int[] nums, int k) {
        // 边界判断已有，无需判断
        // k对数组长度取余,得到右边需要挪到数组前面的数字个数
        int step = k % nums.length;
        // 已经移动的数字个数
        int count = 0;
        // 保存要被复制过去的数字
        int begin = nums[0];
        // 保存下一个将要被覆盖的数字
        int end = 0;
        // 开始位置
        int pos = 0;
        while (count<nums.length){
            int nextPos = (pos +step)%nums.length;
            // 提前保存好将要被覆盖的数字
            end = nums[nextPos];
            // 原来的数字挪到新的位置上
            nums[nextPos] = begin;
            // 移动结束后重置begin
            begin = end;
            // count++
            count++;
            // 更新pos
            pos = nextPos;
        }
    }
}
