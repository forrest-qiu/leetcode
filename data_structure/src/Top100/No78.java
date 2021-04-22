package Top100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */
public class No78 {

    private List<Integer> list = new ArrayList<>();
    private List<List<Integer>> result = new ArrayList<>();


    public List<List<Integer>> subsets(int[] nums) {
        sub(nums,0);
        return result;
    }

    public void sub(int[] nums,int num){
        if(num == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[num]);
        sub(nums,num+1);
        list.remove(list.size()-1);
        sub(nums,num+1);
    }


    @Test
    public void fun(){
        int[] x = new int[]{1,2,3};
        subsets(x);
        System.out.println(result);
    }

}
