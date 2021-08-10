package preday;

import org.junit.Test;

import java.util.Arrays;

public class No611 {
    /**
     * 给定一个包含非负整数的数组，你的任务是统计其中可以组成三角形三条边的三元组个数。
     * @param nums
     * @return
     */
    public int triangleNumber(int[] nums) {
        if(nums.length<3){
            return 0;
        }
        int ans = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int left = j+1, right = nums.length - 1,k = j;
                while (left <= right){
                    int mid = (left + right)/2;
                    if(nums[mid]<nums[i]+nums[j]){
                        k = mid;
                        left = mid +1;
                    }else{
                        right = mid - 1;
                    }
                    ans += k - j;
                }
            }
        }
        return ans;
    }

    @Test
    public void test(){
        int[] nums = {2,2,3,4};
        System.out.println(triangleNumber(nums));
    }
}
