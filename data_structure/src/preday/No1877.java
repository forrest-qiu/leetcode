package preday;

import org.junit.Test;

import java.util.Arrays;

public class No1877 {

    /**
     * 一个数对 (a,b) 的 数对和 等于 a + b 。最大数对和 是一个数对数组中最大的 数对和 。
     *
     * 比方说，如果我们有数对 (1,5) ，(2,3) 和 (4,4)，最大数对和 为 max(1+5, 2+3, 4+4) = max(6, 5, 8) = 8 。
     * 给你一个长度为 偶数 n 的数组 nums ，请你将 nums 中的元素分成 n / 2 个数对，使得：
     *
     * nums 中每个元素 恰好 在 一个 数对中，且
     * 最大数对和 的值 最小 。
     * 请你在最优数对划分的方案下，返回最小的 最大数对和 。
     *
     * @param nums
     * @return
     */
    public int minPairSum(int[] nums) {
        int n = nums.length;
        int ans = 0;
        Arrays.sort(nums);
        for (int i = 0,j = n-1; i < j; i++,j--) {
            ans = Math.max(nums[i]+nums[j],ans);
        }
        return ans;
    }


    @Test
    public void test(){
        int[] nums = {3,5,4,2,4,6};
//        int[] nums = {5,3,5,2,1,5,5,2,3,1};
        System.out.println(minPairSum(nums));
    }
}
