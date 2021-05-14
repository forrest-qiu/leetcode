package Top100;

import org.junit.Test;

/**
 * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积
 */
public class No152 {

    public int maxProduct(int[] nums) {
        int maxF = nums[0], minF = nums[0], ans = nums[0];
        int length = nums.length;
        for (int i = 1; i < length; ++i) {
            int mx = maxF, mn = minF;
            maxF = Math.max(mx * nums[i], Math.max(nums[i], mn * nums[i]));
            minF = Math.min(mn * nums[i], Math.min(nums[i], mx * nums[i]));
            ans = Math.max(maxF, ans);
        }
        return ans;
    }


    public int maxValue(int[] nums,int left,int right,int ans){
        if(left<0||right>=nums.length){
            return ans;
        }
        int temp = nums[left];
        for (int i = left+1; i <= right ; i++) {
            temp = temp * nums[i];
        }
        ans = Math.max(ans,temp);
        return Math.max(maxValue(nums,left-1,right,ans),maxValue(nums,left,right+1,ans));
    }

    @Test
    public void test(){
//        int[] xx = new int[]{-2,0,-1};
//        int[] xx = new int[]{-4,-3};
        int[] xx = new int[]{0,2};
        System.out.println(maxProduct(xx));
    }
}
