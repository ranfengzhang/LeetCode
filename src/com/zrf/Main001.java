package com.zrf;

import java.util.HashMap;
import java.util.Map;

public class Main001 {
    public static void main(String[] args) {

    }
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length==0){
            return null;
        }
        int[] result = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        //key为x，value为下标，才能通过x找到下标
        //在将x插入hash表之前，先判断hash表里是否有target-x
        for(int i = 0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                result[0] = i;
                result[1] = map.get(target-nums[i]);
            }
            map.put(nums[i],i);
        }
        return result;
    }

}
