package Top100;

import org.junit.Test;

/**
 * 给定一个正整数，检查它的二进制表示是否总是 0、1 交替出现：换句话说，就是二进制表示中相邻两位的数字永不相同。
 */
public class No693 {
    public boolean hasAlternatingBits(int n) {
        int temp = n ^ (n >> 1);
        return (temp & (temp+1)) == 0;
    }

    @Test
    public void test(){
        System.out.println(hasAlternatingBits(5));
        System.out.println(hasAlternatingBits(4));
        System.out.println(hasAlternatingBits(7));
        System.out.println(hasAlternatingBits(11));
        System.out.println(hasAlternatingBits(10));
    }
}
