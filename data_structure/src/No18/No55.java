package No18;

import org.junit.Test;

/**
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标。
 */
public class No55 {
    boolean end = false;

    public boolean canJump(int[] nums) {
        if(nums==null||nums.length==1){
            return true;
        }
        tryJump(nums,0);
        return end;
    }

    public void tryJump(int[] nums,int x){
        if(x >= nums.length-1){
            end = true;
            return;
        }
        if(end == true){
            return;
        }
        int num = nums[x];
        if(num>=nums.length){
            end = true;
            return;
        }
        for (int i = 1; i <= num ; i++) {
            tryJump(nums,x+i);
        }
    }

    public boolean canJump2(int[] nums) {
        int n = nums.length;
        int rightMost = 0;
        for (int i = 0; i < n; i++) {
            if(i<=rightMost){
                rightMost = Math.max(rightMost,nums[i]+i);
                if(rightMost>=n-1){
                    return true;
                }
            }
        }
        return false;
    }

    @Test
    public void fun(){
//        int[] nums = {2,3,1,1,4};
//        int[] nums = {3,2,1,0,4};
        int[] nums = {2,0,0};
        System.out.println(canJump(nums));
    }
}
