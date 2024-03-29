package Top100;

import org.junit.Test;

import java.util.Arrays;

/**
 * 给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
 *
 * 给你一个整数 n ，返回和为 n 的完全平方数的 最少数量 。
 *
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 *
 */
public class No279 {

    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,100001);
        dp[0] = 0;
        int num = 1;
        while(num * num <= n){
            int k = num * num;
            for(int i = 1;i <= n;i++)
                if(i >= k)
                    dp[i] = Math.min(dp[i],dp[i-k]+1);
            num += 1;
        }
        return dp[n];
    }


    @Test
    public void test(){
        System.out.println(numSquares(13));
    }

}
