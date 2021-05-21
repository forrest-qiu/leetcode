package Top100;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 *
 * 整数除法仅保留整数部分。
 */
public class No227 {
    public int calculate(String s) {
        char sign = '+';
        int num = 0;
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if(curr>='0'){
                num = num*10 - '0' + curr;
            }
            if((curr<'0'&&curr!=' ')||i==s.length()-1){
                switch (sign){
                    case '+':stack.push(num);break;
                    case '-':stack.push(-num);break;
                    case '*':stack.push(stack.pop()*num);break;
                    case '/':stack.push(stack.pop()/num);break;
                }
                sign = curr;
                num = 0;
            }
        }
        return stack.stream().mapToInt(Integer::intValue).sum();
    }
}
