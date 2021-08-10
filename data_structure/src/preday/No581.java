package preday;

import org.junit.Test;

/**
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 *
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No581 {

    public int findUnsortedSubarray(int[] nums) {
        int start = -1, end = -1,max = Integer.MIN_VALUE,min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(max>nums[i]){
                end = i;
            }
            max = Math.max(nums[i],max);
        }
        for (int i = nums.length-1; i >=0 ; i--) {
            if(nums[i]>min){
                start = i;
            }
            min = Math.min(min,nums[i]);
        }
        if(end==-1&&start==-1){
            return 0;
        }
        return end-start+1;
    }

    @Test
    public void test(){
//        int[] nums = {2,6,4,8,10,9,15};
//        int[] nums = {1,3,2,2,2};
        int[] nums = {1,2,3,3,3};
//        int[] nums = {1,2,3,4};
//        int[] nums = {1};
        System.out.println(findUnsortedSubarray(nums));

    }
}
