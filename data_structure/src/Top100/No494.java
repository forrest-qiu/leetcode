package Top100;

import org.junit.Test;

/**
 * 给你一个整数数组 nums 和一个整数 target 。
 *
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 *
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 */
public class No494 {
    /**
     * 动态规划
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if(sum<target||(sum+target)%2>0){
            return 0;
        }
        return fun(nums,(target+sum)>>>1);
    }

    public int fun(int[] nums,int target){
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = target; i >= num ; i--) {
                dp[i] += dp[i - num];
            }
        }
        return dp[target];
    }

    @Test
    public void test(){
        int[] nums ={1,1,1,1,1};
        System.out.println(findTargetSumWays(nums,3));
    }
}
