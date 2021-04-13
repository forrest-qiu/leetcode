package No18;

import java.util.Arrays;

public class No41 {

    /**
     * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        if(nums.length==0){
            return 1;
        }
        Arrays.sort(nums);
        if(nums[0]>1){
            return 1;
        }
        if(nums[nums.length-1]<1){
            return 1;
        }
        int temp = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if(nums[i]<=0&&nums[i+1]>1){
                return 1;
            }
            temp = nums[i]+1;
            if(temp>0&&nums[i+1]>temp){
                return temp;
            }
        }
        return nums[nums.length-1]+1;
    }
}
