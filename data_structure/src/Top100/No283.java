package Top100;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */
public class No283 {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        for (int i = n - 1; i >= 0 ; i--) {
            if(nums[i]==0){
                for (int j = i; j < n - 1; j++) {
                    if(nums[j+1]==0){
                        break;
                    }
                    swap(nums,j,j+1);
                }
            }
        }
    }

    public void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void moveZeroes2(int[] nums) {
        int n = nums.length;
        int slow = 0;
        for (int i = 0; i < n; i++) {
            if(nums[i]!=0){
                nums[slow++] = nums[i];
            }
        }
        for (int i = slow; i < n; i++) {
            nums[i] = 0;
        }
    }


}
