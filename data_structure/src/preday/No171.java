package preday;

import org.junit.Test;

public class No171 {

    public int titleToNumber(String columnTitle) {
        char[] chars = columnTitle.toCharArray();
        int n = chars.length;
        int ans = 0;
        for (int i = 0; i < n  ; i++) {
            char x = chars[i];
            int val = x - 'A' + 1;
            ans =  ans * 26 + val;
        }
        return ans;
    }

    @Test
    public void test(){
        System.out.println(titleToNumber("AA"));
        System.out.println(titleToNumber("ZY"));
        System.out.println(titleToNumber("AB"));
        System.out.println(titleToNumber("FXSHRXW"));
    }
}
