package tencent;

import org.junit.Test;

public class No122 {
    /**
     * 给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        //动态规划
        int n = prices.length;
        //dp[i][0]代表第n天持股能获取的最大收益，dp[i][1]代表第n天没持股能获取的最大收益
        int[][] dp = new int[n][2];
        if(n==0){
            return 0;
        }
        dp[0][0] = 0 - prices[0];
        dp[0][1] = 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] + prices[i]);
        }
        return dp[n-1][1];
    }

    @Test
    public void test(){
        System.out.println(maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
