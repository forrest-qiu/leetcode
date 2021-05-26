package Top100;

import org.junit.Test;

/**
 * 给出一个字符串 s（仅含有小写英文字母和括号）。
 *
 * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
 *
 * 注意，您的结果中 不应 包含任何括号。
 *
 */
public class No1190 {
    public String reverseParentheses(String s) {
        StringBuffer sb = new StringBuffer(s);
        while(sb.indexOf("(")!=-1){
            int left = sb.lastIndexOf("(");
            int right = sb.indexOf(")",left);
            String reverse = sb.substring(left+1,right);
            sb = sb.replace(left,right+1,reverse(reverse));
        }
        return sb.toString();
    }

    public String reverse(String str){
        StringBuffer sb = new StringBuffer();
        for (int i = str.length() -1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    @Test
    public void test(){
        System.out.println(reverseParentheses("(ed(et(oc))el)"));
    }
}
