package com.zrf;

public class Main004 {
    public static void main(String[] args) {
        int[] nums1 ={1,2};
        int[] nums2 ={1,2,3,4,5,6,7,8,9,10};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int left = (len1+len2+1)/2;
        int right = (len1+len2+2)/2;
        //兼顾奇数和偶数的情况
        int sum = getKth(nums1,0,len1-1,nums2,0,len2-1,left)+getKth(nums1,0,len1-1,nums2,0,len2-1,right);
        return sum/2.0;
    }
    //获取第k个数
    public static int getKth(int[]nums1,int start1,int end1,int[]nums2,int start2,int end2,int k){
        int l1 = end1-start1+1;
        int l2 = end2-start2+1;
        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
        //就是如果len1长度小于len2，把getKth()中参数互换位置，即原来的len2就变成了len1，即len1，永远比len2小
        if(l1>l2){
            return getKth(nums2,start2,end2,nums1,start1,end1,k);
        }
        //如果一个数组中没有了元素，那么即从剩余数组nums2的其实start2开始加k再-1.
        //因为k代表个数，而不是索引，那么从nums2后再找k个数，那个就是start2 + k-1索引处就行了。因为还包含nums2[start2]也是一个数。因为它在上次迭代时并没有被排除
        if (l1==0){
            return nums2[start2+k-1];
        }
        //如果k=1，表明最接近中位数了，即两个数组中start索引处，谁的值小，中位数就是谁(start索引之前表示经过迭代已经被排出的不合格的元素，即数组没被抛弃的逻辑上的范围是nums[start]--->nums[end])。
        if(k==1){
            return Math.min(nums1[start1],nums2[start2]);
        }
        //为了防止数组长度小于 k/2,每次比较都会从当前数组所生长度和k/2作比较，取其中的小的(如果取大的，数组就会越界)
        //然后素组如果len1小于k / 2，表示数组经过下一次遍历就会到末尾，然后后面就会在那个剩余的数组中寻找中位数
        int i = start1+Math.min(k/2,l1)-1;
        int j = start2+Math.min(k/2,l2)-1;
        if(nums1[i]<nums2[j]){
            return getKth(nums1,i+1,end1,nums2,start2,end2,k-(i-start1+1));
        }else{
            return getKth(nums1,start1,end1,nums2,j+1,end2,k-(j-start2+1));
        }
    }
}
