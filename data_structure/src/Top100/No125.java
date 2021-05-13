package Top100;

import org.junit.Test;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 */
public class No125 {
    public boolean isPalindrome(String s) {
        int n = s.length();
        if(n==0){
            return true;
        }
        int i = 0,j = n-1;
        while (i < j){
            while(i<j&&!isNumberOrChar(s.charAt(i))){
                i++;
            }
            while(j>i&&!isNumberOrChar(s.charAt(j))){
                j--;
            }
            if(i>j){
                return true;
            }
            if(!String.valueOf(s.charAt(i)).equalsIgnoreCase(String.valueOf(s.charAt(j)))){
                return false;
            }else{
                i++;
                j--;
            }
        }
        return true;
    }

    public boolean isNumberOrChar(char x){
        if(x >= '0' && x <= '9'){
            return true;
        }
        if( x >= 'a' && x  <= 'z'){
            return true;
        }
        if(x >= 'A' && x <= 'Z'){
            return true;
        }
        return false;
    }

    @Test
    public void test(){
        String s = "A man, a plan, a canal: Panama";
//        String s = ".,";
        int x = 'a';
        int y = 'z';
        int i = '0';
        int k = '9';
        System.out.println(x);
        System.out.println(y);
        System.out.println(i);
        System.out.println(k);
        System.out.println(isPalindrome(s));
    }
}
