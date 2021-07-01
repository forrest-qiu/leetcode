package Top100;

import org.junit.Test;

/**
 * 给你一个整数 columnNumber ，返回它在 Excel 表中相对应的列名称
 */
public class No168 {

    public String convertToTitle(int columnNumber) {
        if(columnNumber==0){
            return "";
        }
        StringBuffer ans = new StringBuffer();
        while(columnNumber>0){
            columnNumber--;
            ans.append((char) (columnNumber % 26 + 'A'));
            columnNumber = columnNumber / 26;
        }
        return ans.reverse().toString();
    }


    @Test
    public void test(){
//        System.out.println(convertToTitle(701));
//        System.out.println(convertToTitle(28));
//        System.out.println(convertToTitle(2147483647));
        System.out.println(convertToTitle(52));
    }
}
