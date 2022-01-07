package com.zrf;

import java.util.HashMap;
import java.util.Map;

public class Main8 {
    public static void main(String[] args) {
        String str = "  -42";
        System.out.println(new Main8().myAtoi(str));
    }
    public int myAtoi(String s) {
        Automaton automaton = new Automaton();
        int length = s.length();
        for (int i = 0;i<length;i++){
            // 将字符串的每一位输入状态机
            automaton.get(s.charAt(i));
        }

        return (int)automaton.result*automaton.signed;
    }
    class Automaton{
        public int signed = 1;
        // 不断更新结果，定义为long不用提前判定越界
        public long result = 0;
        private String state = "start";
        private Map<String,String[]> table = new HashMap<String,String[]>(){{
            put("start",new String[]{"start","signed","in_number","end"});
            put("signed",new String[]{"end","end","in_number","end"});
            put("in_number",new String[]{"end","end","in_number","end"});
            put("end",new String[]{"end","end","end","end"});
        }};
        public void get(char c){
            // 获取更新后的状态
            state = table.get(state)[getCol(c)];
            if ("in_number".equals(state)){
                result = 10*result + c-'0';
                // 判断结果是否越界
                result = signed ==1?Math.min(result,(long)Integer.MAX_VALUE):Math.min(result,-(long)Integer.MIN_VALUE);
            }else if ("signed".equals(state)){
                // 更新符号
                signed = c =='+'?1:-1;
            }
        }
        private int getCol(char c){
            if (c==' '){
                return 0;
            }
            if (c=='+' || c=='-'){
                return 1;
            }
            if (Character.isDigit(c)){
                return 2;
            }
            return 3;
        }
    }
}
