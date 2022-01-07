package com.zrf;

public class Main191 {
    public static void main(String[] args) {
        int n = Integer.parseUnsignedInt("11111111111111111111111111111101");
        System.out.println(new Main191().hammingWeight(n));
    }
    public int hammingWeight(int n) {
        int count = 0;
        while (n>0){
            int rev = n&1;
            count += rev==1?1:0;
            n>>>=1;
        }
        return count;
    }
}
