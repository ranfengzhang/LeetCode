package com.zrf;

import java.util.HashMap;
import java.util.Map;

public class Main242 {
    public static void main(String[] args) {
        String s = "rat";
        String t = "car";
        System.out.println(new Main242().isAnagram(s,t));
    }
    public boolean isAnagram(String s, String t) {
        if (s.length()!=t.length()){
            return false;
        }
        // hash表
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0;i<s.length();i++){
            int count = map.getOrDefault(s.charAt(i),0);
            map.put(s.charAt(i),count+1);
        }
        for (int i =0;i<t.length();i++){
            int count = map.getOrDefault(s.charAt(i),0);
            if (count ==0){
                return false;
            }else {
                map.put(s.charAt(i),count-1);
            }
        }
        int nums = 0;
        for (Map.Entry<Character,Integer> entry : map.entrySet()){
            if (entry.getValue()!=0){
                nums++;
            }
        }
        if (nums>0){
            return false;
        }
        return true;
    }
}
