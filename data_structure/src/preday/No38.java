package preday;

import org.junit.Test;

public class No38 {
    /**
     * 给定一个正整数 n ，输出外观数列的第 n 项。
     *
     * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
     *
     * 你可以将其视作是由递归公式定义的数字字符串序列：
     *
     * countAndSay(1) = "1"
     * countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/count-and-say
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        if(n == 1){
            return "1";
        }
        String x = countAndSay(n-1);
        char[] chars = x.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < chars.length; i++) {
            int count = 1;
            char temp = chars[i];
            while(i+1 < chars.length && chars[i+1] == chars[i]){
                count++;
                i++;
            }
            sb.append(count).append(temp);
        }
        return sb.toString();
    }

    @Test
    public void test(){
        System.out.println(countAndSay(2));
        System.out.println(countAndSay(3));
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(5));
        System.out.println(countAndSay(6));
    }
}
