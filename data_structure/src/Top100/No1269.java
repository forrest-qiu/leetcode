package Top100;

import org.junit.Test;

/**
 * 有一个长度为 arrLen 的数组，开始有一个指针在索引 0 处。
 *
 * 每一步操作中，你可以将指针向左或向右移动 1 步，或者停在原地（指针不能被移动到数组范围外）。
 *
 * 给你两个整数 steps 和 arrLen ，请你计算并返回：在恰好执行 steps 次操作以后，指针仍然指向索引 0 处的方案数。
 *
 * 由于答案可能会很大，请返回方案数 模 10^9 + 7 后的结果。
 *
 */
public class No1269 {

    int ans = 0;

    public int numWays(int steps, int arrLen) {
        dfs(0,0,steps,0,arrLen,0);
        return ans;
    }

    public void dfs(int curr,int step,int steps,int index,int arrLen,int next){
        if(step>steps){
            return;
        }
        if(index>=arrLen||index<0){
            return;
        }
        if(step==steps&&curr+next==0){
            ans++;
            return;
        }
        int temp = curr+next;
        dfs(temp,step+1,steps,index,arrLen,0);
        dfs(temp,step+1,steps,index+1,arrLen,1);
        dfs(temp,step+1,steps,index-1,arrLen,-1);
    }


    public int numWays2(int steps, int arrLen) {
        final int MODULO = 1000000007;
       int a = Math.min(steps,arrLen-1);
        //int[i][j]代表j步走到位置i的方案数
       int[][] dp = new int[steps+1][a+1];
       dp[0][0] = 1;
        for (int i = 0; i <= steps; i++) {
            for (int j = 0; j <= a; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j - 1 >= 0) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j - 1]) % MODULO;
                }
                if (j + 1 <= a) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j + 1]) % MODULO;
                }
            }
        }
        return dp[steps][0];
    }

    @Test
    public void test(){
        System.out.println(numWays(4,2));
    }
}
