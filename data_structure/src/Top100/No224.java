package Top100;

import org.junit.Test;

import java.util.*;

/**
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 */
public class No224 {
    /**
     * 需要用到栈结构
     * 从头开始将值入栈，遇到'）'，开始出栈，遇到'（'停止出栈，计算之前出栈数的和入栈，继续数组的入栈，最后计算栈中算式的和
     *
     * @param s
     * @return
     */
    public int calculate(String s) {
        int len = s.length();
        Deque<String> stack = new LinkedList<>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < len; i++) {
            if(s.charAt(i)==' '){
                continue;
            }
            if(s.charAt(i) == ')'){
                while (!stack.isEmpty()) {
                    String pop = stack.pop();
                    if (pop.equals("(")) {
                        stack.push(getSum(sb.toString()));
                        sb = new StringBuffer();
                        break;
                    } else {
                        sb = new StringBuffer(pop).append(sb);
                    }
                }
            }else{
                stack.push(s.charAt(i) + "");
            }
        }
        while (!stack.isEmpty()) {
            sb.append(stack.removeLast());
        }
        return Integer.valueOf(getSum(sb.toString()) + "");
    }

    public String getSum(String s) {
        String[] marks = s.split("\\d+");
        String[] nums = s.split("(\\+|\\-)+");
        int ans = 0;
        int x = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i].length()==0){
                x++;
                continue;
            }
            int temp = 1;
            if(marks.length>0){
                String mark = marks[i-x];
                if(mark.length()>0){
                    for (int j = 0; j < mark.length(); j++) {
                        if(mark.charAt(j)=='-'){
                            temp = temp * -1;
                        }
                    }
                }
            }
            ans += (temp * Integer.valueOf(nums[i]));
        }
        return ans+"";
    }


    public int calculate2(String s){
        Deque<Integer> ops = new LinkedList<Integer>();
        ops.push(1);
        int sign = 1;

        int ret = 0;
        int n = s.length();
        int i = 0;
        while (i < n) {
            if (s.charAt(i) == ' ') {
                i++;
            } else if (s.charAt(i) == '+') {
                sign = ops.peek();
                i++;
            } else if (s.charAt(i) == '-') {
                sign = -ops.peek();
                i++;
            } else if (s.charAt(i) == '(') {
                ops.push(sign);
                i++;
            } else if (s.charAt(i) == ')') {
                ops.pop();
                i++;
            } else {
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                ret += sign * num;
            }
        }
        return ret;
    }


    @Test
    public void test() {
        String s = "(1+(4+5+2)-3)+(6+8)";
//        String s = " 2-1 + 2 ";
//        String s = "-2+ 1";
//        String s = "2-(5-6)";
//        String s = "(1-(3-4))";
//        String s = "(6)-(8)-(7)+(1+(6))";
        System.out.println(calculate(s));
//        System.out.println(getSum("1--2+31-2--4"));
    }
}
