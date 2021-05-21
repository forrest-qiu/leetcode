package Top100;

/**
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 */
public class No231 {
    public boolean isPowerOfTwo(int n) {
        return n>0?Integer.bitCount(n)==1:false;
    }

}
