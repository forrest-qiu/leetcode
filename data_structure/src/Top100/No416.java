package Top100;

import org.junit.Test;

import java.util.Arrays;

/**
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 */
public class No416 {
    //dp[i] 表示nums中是否存在分割成两个子集并且子集元素和相等且为i
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int sum = 0, maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            for (int j = target; j >= num; --j) {
                dp[j] |= dp[j - num];
            }
        }
        return dp[target];
    }


    public boolean canPartition2(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if(sum%2==1){
            return false;
        }
        if(nums[nums.length -1]>sum/2){
            return false;
        }
        int a = 0, b = 0;
        int i = nums.length - 1;
        while (i >= 0) {
            a = nums[i] + a;
            b = sum - a;
            if (a == b) {
                return true;
            }
            if (a > b) {
                return false;
            }
            i--;
        }
        return false;
    }

    @Test
    public void test(){
        int[] x = {3,3,3,4,5};
        System.out.println(canPartition2(x));
    }
}
