package tencent;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class ThreeSumClosest {
	
	 public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int closest = nums[0] + nums[1] + nums[2];
		int diff = Math.abs(closest - target);
		for (int i = 0; i < nums.length -2; i++) {
			int left = i+1,right = nums.length -1;
			while(left<right) {
				int sum = nums[i] + nums[left]+nums[right];
				int newDiff = Math.abs(sum - target);
				if(diff > newDiff) {
					diff = newDiff;
					closest = sum;
				}
				if(sum < target) {
					left++;
				}else {
					right--;
				}
			}
		}
		return closest;
    }
	 
	 
	@Test
	public void fun() {
		int[] nums = {0,2,1,-3};
//		int[] nums = {1,1,1,1};
		int target = 1;
		System.out.println(threeSumClosest(nums,target));
		
		
	}
}
