package com.zrf;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int m = -5;
        int result = m>>>2;
        System.out.println("m:"+Integer.toBinaryString(m));
        System.out.println("binary result:"+Integer.toBinaryString(result));
        System.out.println("result:"+result);
    }
}
