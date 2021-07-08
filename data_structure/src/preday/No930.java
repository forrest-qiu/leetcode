package preday;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class No930 {
    /**
     * 给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。
     *
     * 记录所有前缀和出现的次数，遍历sum[j],如果出现sum[j]-goal的前缀和，就是以j为右边界符合答案的次数
     *
     * @param nums
     * @param goal
     * @return
     */
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0,ans = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(map.containsKey(sum - goal)){
                ans += map.get(sum - goal);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return ans;
    }

    @Test
    public void test(){
        int[] nums = {1,0,1,0,1};
        System.out.println(numSubarraysWithSum(nums,2));
    }
}
