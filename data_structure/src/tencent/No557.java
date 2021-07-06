package tencent;

import org.junit.Test;

public class No557 {

    public String reverseWords(String s) {
        String[] s1 = s.split(" ");
        StringBuffer ans = new StringBuffer();
        for (String s2 : s1) {
            ans.append(new StringBuffer(s2).reverse());
            ans.append(" ");
        }
        return ans.substring(0,ans.lastIndexOf(" "));
    }

    @Test
    public void test(){
        String str = "Let's take LeetCode contest";
        System.out.println(reverseWords(str));
    }
}
