package Top100;

import org.junit.Test;

/**
 * 给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
 *
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 *
 * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 *
 */
public class No309 {

    /**
     * 使用dp[i][j]表示第i天的收益
     * 其中j = 0 表示不持股
     * j = 1表示冷冻
     * j = 2表示持有
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n==0){
            return 0;
        }
        int[][] dp = new int[n][n];
        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[0][2] = -prices[0];
        for (int i = 1; i < n; i++) {
            /**
             * 第i天不持股，前一天可能也不持股或是冷冻
             */
            dp[i][0] = Math.max(dp[i-1][1],dp[i-1][0]);
            //第i天冷冻，前一天为不持股
            dp[i][1] = dp[i-1][2] + prices[i];
            //第i天持股，前一天为不持有或是持股
            dp[i][2] = Math.max(dp[i-1][0]-prices[i],dp[i-1][2]);
        }
        return Math.max(dp[n-1][0],dp[n-1][1]);
    }

    @Test
    public void test(){
      int[] prices = {1,2,3,0,2};
      System.out.println(maxProfit(prices));
    }

}
