package Top100;

import org.junit.Test;

/**
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 */
public class No560 {

    /**
     * 暴力双重循环
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int ans = 0,sum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length ; j++) {
                sum += nums[j];
                if(sum == k){
                    ans++;
                }
            }
            sum = 0;
        }
        return ans;
    }

    /**
     * 滑动窗口
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum2(int[] nums, int k) {
        int ans = 0,left = 0,right= 0,sum = 0;
        int n = nums.length;
        while(right<n&&left<=right){
            if(sum<k){
                sum += nums[right];
            }
            if(sum==k){
                ans++;
                left++;
                sum -= nums[left];
            }
            right++;
        }
        return ans;
    }

    @Test
    public void test(){
//        int[] nums = {1,1,1};
//        System.out.println(subarraySum2(nums,2));
        int[] nums = {1,-1,0};
        System.out.println(subarraySum(nums,0));
    }

}
