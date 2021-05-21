package Top100;

import java.util.*;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 */
public class No215 {

    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    public void quickSort(int[] nums){
        int n = nums.length;
        int mid = n/2;

    }

    public void fun(int[] nums,int left,int right){
        
    }
}
