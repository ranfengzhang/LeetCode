package com.zrf;

public class Main56 {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{2,3},{4,5},{6,7},{8,9},{1,10}};
        System.out.println(new Main56().merge(intervals));
    }
    public int[][] merge(int[][] intervals) {
        // 两两合并
        int m = intervals.length;
        int count = m;
        for (int i = 0;i<m;i++){
            for (int j =0;j<m;j++){
                if (intervals[i][0]>intervals[j][1] || intervals[j][0]>intervals[i][1] || intervals[i][0]==-1 || intervals[j][0] ==-1){
                    continue;
                }else {
                    intervals[i][0] =  Math.min(intervals[i][0],intervals[j][0]);
                    intervals[i][1] = Math.max(intervals[i][1],intervals[j][1]);
                    intervals[j][0] = -1;
                    intervals[j][1] = -1;
                    count--;
                }
            }
        }
        int[][] result = new int[count][2];
        int index = 0;
        for (int i = 0;i<m;i++){
            int i2 = intervals[i][1];
            if (i2>=0){
                result[index++] = intervals[i];
            }
        }
        return result;
    }
}
