package Top100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 */
public class No22 {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        backtrace(list,new StringBuffer(),0,0,n);
        return list;
    }


    public void backtrace(List<String> list,StringBuffer current,int open,int close,int n){
        String s = current.toString();
        if(current.length() == 2*n){
            list.add(s);
            return;
        }
        if(open<n){
            current.append("(");
            backtrace(list,current,open+1,close,n);
            current.deleteCharAt(current.length()-1);
        }
        if(close<open){
            current.append(")");
            backtrace(list,current,open,close+1,n);
            current.deleteCharAt(current.length()-1);
        }
    }

    @Test
    public void test(){
        System.out.println(generateParenthesis(3));

    }
}
