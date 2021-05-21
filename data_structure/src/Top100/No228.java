package Top100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个无重复元素的有序整数数组 nums 。
 *
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 *
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 *
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 *
 */
public class No228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int start = 0;
        int end = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]-nums[i-1]>1||i==nums.length-1){
                end = nums[i]-nums[i-1]==1?i:i-1;
                ans.add(end-start>0?nums[start]+"->"+nums[end]:nums[start]+"");
                if(i==nums.length-1&&(nums[i]-nums[i-1]>1||nums[i]-nums[i-1]<0)){
                    ans.add(nums[nums.length-1]+"");
                }
                start = i;
            }
        }
        return ans;
    }

    @Test
    public void test(){
//        int[] nums = {0,1,2,4,5,7};
//        int[] nums = {0,2,3,4,6,8,9};
        int[] nums = {-2147483648,-2147483647,2147483647};
        System.out.println(2147483647-(-2147483647));
        System.out.println(summaryRanges(nums));
    }
}
