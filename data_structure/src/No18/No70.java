package No18;

import org.junit.Test;

public class No70 {
    /**
     * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
     *
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * @param n
     * @return
     */
    public int climbStairs(int n) {
       int a = 0,b = 0;
       int result = 1;
        for (int i = 1; i < n; i++) {
            a = b;
            b = result;
            result = a + b;
        }
        return result;
    }

    @Test
    public void fun(){
        System.out.println(climbStairs(6));
    }

}
