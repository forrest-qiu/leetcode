package Top100;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * <p>
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * <p>
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * <p>
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 */
public class No394 {

    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder(s);
        while (sb.indexOf("[") != -1) {
            int leftIndex = sb.lastIndexOf("[");
            int rightIndex = sb.indexOf("]", leftIndex);
            String str = sb.substring(leftIndex + 1, rightIndex);
            int i = leftIndex - 1, count = 0, base = 1;
            while (i >= 0 && Character.isDigit(sb.charAt(i))) {
                count += base * (sb.charAt(i) - '0');
                base *= 10;
                i--;
            }
            StringBuilder tmp = new StringBuilder();
            for (int j = 0; j < count; j++) tmp.append(str);
            sb = sb.replace(i + 1, rightIndex + 1, tmp.toString());
        }
        return sb.toString();
    }

    @Test
    public void test(){
//        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("3[a2[c]]"));
//        System.out.println(decodeString("abc3[cd]xyz"));
    }
}
