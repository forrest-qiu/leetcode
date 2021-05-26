package Top100;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 有台奇怪的打印机有以下两个特殊要求：
 *
 * 打印机每次只能打印由 同一个字符 组成的序列。
 * 每次可以在任意起始和结束位置打印新字符，并且会覆盖掉原来已有的字符。
 * 给你一个字符串 s ，你的任务是计算这个打印机打印它需要的最少打印次数。
 *
 */
public class No664 {

    /**
     * 思路分析： 使用动态规划法。dp[i][j]代表的是s[i, j]段打印的最少次数
     * 状态转移方程：打印s[i, j]这段共有三种情况
     *
     * 第一种：dp[i][j] = 1 + dp[i + 1][j];//i单独打印， s[i + 1, j]段另外打印
     * 第二种：dp[i][j] = min(dp[i][j], dp[i + 1][k] + dp[k + 1][j]);//dp[i + 1][k]代表将i放到[i+ 1, k]一起打印，dp[k + 1][j]代表[k + 1, j]另外打印，（s[i] == s[k])
     * 第三种：dp[i][j] = min(dp[i][j], dp[i + 1][j]);//dp[i + 1][j]代表将i放入[j + 1, i]一起打印(s[i] == s[j])
     * @param s
     * @return
     */
    public int strangePrinter(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = n-1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i+1; j < n; j++) {
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j] = dp[i][j-1];
                }else{
                    int min = Integer.MAX_VALUE;
                    for (int k = i; k < j ; k++) {
                        min = Math.min(min,dp[i][k]+dp[k+1][j]);
                    }
                    dp[i][j] = min;
                }
            }
        }
        return dp[0][n-1];
    }

    @Test
    public void test(){
        System.out.println(strangePrinter("aba"));
    }

}
