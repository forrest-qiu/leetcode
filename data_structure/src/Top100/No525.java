package Top100;

import org.junit.Test;

public class No525 {
    /**
     * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
     * @param nums
     * @return
     */
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        if(n<2){
            return 0;
        }
        int[] dp = new int[n];
        dp[0] = 0;
        int x = nums[0]^nums[1];
        dp[1] = x*2;
        if(n==2){
            return dp[1];
        }
        int count0 = 0,count1 = 0;
        for (int i = 2; i < n; i++) {
            int y = x ^ nums[i];
            if(y == x){
                dp[i] = dp[i-1];
            }else {
                dp[i] = dp[i-1] + 2;
            }
            x = y;
        }
        return dp[n-1];
    }

    @Test
    public void test(){
        int[] nums = {0,1,1};
        System.out.println(findMaxLength(nums));
    }
}
