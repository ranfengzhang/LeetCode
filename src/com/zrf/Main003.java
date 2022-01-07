package com.zrf;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main003 {
    public static void main(String[] args) {
//        String s = "bbbb";
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
        System.out.println(lengthOfLongestSubstring2(s));
    }
    public static int lengthOfLongestSubstring(String s) {
        if (null==s || s.length()==0){
            return 0;
        }
        int result = 1;
        for (int i = 0;i<s.length();i++){
            Set<Character> set = new HashSet<>();
            set.add(s.charAt(i));
            int temp = 1;
            for (int j = i+1;j<s.length();j++){
                if (set.contains(s.charAt(j))){
                    break;
                }else {
                    set.add(s.charAt(j));
                    temp++;
                }
            }
            if (temp>result){
                result = temp;
            }
        }
        return result;
    }
    //KMP算法
    public static int lengthOfLongestSubstring2(String s) {
        if (null==s || s.length()==0){
            return 0;
        }
        int max = 0;

        Map<Character,Integer> map = new HashMap<>();

        for (int start = 0,end =0;end<s.length();end++){
            char c= s.charAt(end);

            if (map.containsKey(c)){
               start = Math.max(map.get(c)+1,start);
            }
            map.put(c,end);
            max = Math.max(max,end-start+1);
        }
        return max;
    }
}
