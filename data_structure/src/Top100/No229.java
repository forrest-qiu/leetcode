package Top100;

import org.junit.Test;

import java.util.*;

/**
 * 给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。
 *
 * 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。
 *
 */
public class No229 {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        int target = n/3;
        if(target==0){
            Set<Integer> x = new HashSet<>();
            for (int num : nums) {
                x.add(num);
            }
            return new ArrayList<>(x);
        }
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]==nums[i-1]){
                count++;
                if(count>target&&i==nums.length-1){
                    ans.add(nums[i-1]);
                }
            }else{
                if(count>target){
                    ans.add(nums[i-1]);
                }
                count = 1;
            }
        }
        return ans;
    }

    @Test
    public void test(){
//        int[] nums = new int[]{3,2,3};
//        int[] nums = new int[]{1,1,1,3,3,2,2,2};
        int[] nums = new int[]{1};
        System.out.println(majorityElement(nums));
    }
}
