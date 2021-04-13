package No18;

public class No53 {

    /**
     * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int pre = 0;int max = nums[0];
        for (int num : nums) {
            pre = Math.max(pre+num,num);
            max = Math.max(pre,max);
        }
        return max;
    }
}
