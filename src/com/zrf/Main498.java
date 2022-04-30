package com.zrf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main498 {
    public static void main(String[] args) {
//        int[][] mat = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        int[][] mat = new int[][]{{2,3}};
        int[] result = new Main498().findDiagonalOrder(mat);
    }
    public int[] findDiagonalOrder(int[][] mat) {
        // 可以发现一个规律，遍历到第n层，坐标的和等于n。n从0开始到m-1+n-1
        int m = mat.length;
        int n = mat[0].length;
        // 层数
        int level = m-1+n-1;
        int[] result = new int[m*n];
        int index = 0;
        // 每层遍历，如果是奇数层，翻转结果
        for (int k = 0;k<=level;k++){
            List<Integer> list = new ArrayList<>();
            // 设置起始坐标，得出row和col的规律
            int row = k < n ? k : n-1;
            int col = k < n ? 0 : k-n+1;
            // 假设都是从左下到右上的顺序，row是在变小，col在变大
            while (row >=0 && col < n) {
                list.add(mat[row][col]);
                --row;
                ++col;
            }
            if (k%2==1){
                Collections.reverse(list);
            }
            // 把list的结果复制到结果中
            for(int i = 0;i<list.size();i++){
                result[index++] = list.get(i);
            }

        }
        return result;
    }
}
