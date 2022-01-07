package com.zrf;

public class Main88 {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,0,0,0};
        int[] nums2 = new int[]{2,5,6};
        new Main88().merge(nums1,3,nums2,3);
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 两个数组的初始下标
        int i = m-1;
        int j = n-1;
        int index = m+n-1;
        while (i>=0 || j>=0){
            // 如果有一个数组到头了
            if (i<0){
                nums1[index--] = nums2[j--];
            }else if (j<0){
                nums1[index--] = nums1[i--];
            }else if (nums1[i]>nums2[j]){
                // 大的先填充
                nums1[index--] = nums1[i--];
            }else {
                nums1[index--] = nums2[j--];
            }
        }
    }
}
