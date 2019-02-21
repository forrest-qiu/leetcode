package tencent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;


public class ThreeNumsSum {
	
	/**
	 * 	三数之和
	 * 	给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> threeSum(int[] nums){
		List<List<Integer>> result = new ArrayList<>();
		if(nums == null || nums.length < 3) {
			return result;
		}
		List<Integer> list = new ArrayList<Integer>(nums.length);
		for (int i : nums) {
			list.add(i);
		}
		Collections.sort(list);
		//如果最大值小于0，而最小值大于0，则说明数组无法找到和为0的三个数
		if(list.get(list.size()-1)<0||list.get(0)>0) {
			return result;
		}
		for(int i = 0;i < nums.length; i++) {
			if(list.get(i)>0) {
				break;
			}
			if(i>0 && list.get(i) == list.get(i-1)) {
				continue;
			}
			int start = i+1,end = list.size() - 1;
			int target = 0 - list.get(i);
			while(end>start) {
				int tempSum = list.get(start)+list.get(end);
				if(tempSum>target) {
					 --end;
				}else if(tempSum == target) {
					List<Integer> tempList = new ArrayList<>(3);
					tempList.add(list.get(start));
					tempList.add(list.get(i));
					tempList.add(list.get(end));
					result.add(tempList);
					while(start < end && list.get(start) == list.get(start+1)) {
						++start;
					}
					while(start < end && list.get(end) == list.get(end -1)) {
						 --end;
					}
					--end ;
					++start ;
				}else {
					start++;
				}
			}
		}
		return result;
	}
	
	@Test
	public void fun() {
		int[] nums = {-1, 0, 1, 2, -1,-4};
//		int[] nums = {0, 0, 0};
		List<List<Integer>> list = threeSum(nums);
		System.out.println(list);
	}
	
	
}
