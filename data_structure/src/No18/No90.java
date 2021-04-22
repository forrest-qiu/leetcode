package No18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *
 */
public class No90 {

    private List<Integer> list = new ArrayList<>();
    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(false,0,nums);
        return result;
    }

    public void dfs(boolean pre,int curr,int[] nums){
        if(curr == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        dfs(false,curr+1,nums);
        if(curr>0&&!pre&&nums[curr] == nums[curr-1]){
            return;
        }
        list.add(nums[curr]);
        dfs(true,curr+1,nums);
        list.remove(list.size()-1);
    }
}
