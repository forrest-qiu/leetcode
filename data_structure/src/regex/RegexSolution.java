package regex;

import org.junit.Test;

/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 */
public class RegexSolution {

    public boolean isMatch(String s,String p){
        if(s == null || p == null){
            return false;
        }
        char[] chars = s.toCharArray();
        char[] chars1 = p.toCharArray();
        int j = 0;
        for (int i = 0; i < chars.length; i++) {
           if(isEq(chars[i],chars1[j])){
               j++;
           }else if(chars1[j] == '*' &&  isEq(chars[i],chars1[j-1])){
               i++;
           }else if(!isEq(chars[i],chars1[j]) && j< chars1.length - 1 && chars1[j+1] == '*' ){
               j+=2;
           }else{
               return false;
           }
        }
        return true;
    }


    public boolean isMatch2(String s,String p){



        return false;
    }

    private boolean isEq(char c1,char c2){
        if(c1 == c2){
            return true;
        }else if(c2 == '.'){
            return true;
        }else{
            return false;
        }
    }

    @Test
    public void fun(){
//        String s = "ab", p = ".*";
//        String s = "aa", p = "a*";
        String s = "aab", p = "c*a*b";
        System.out.println(isMatch(s,p));
    }

}
