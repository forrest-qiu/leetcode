package No18;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class No46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backTrace(result,new ArrayList<>(),nums);
        return result;
    }

    public void backTrace(List<List<Integer>> result,List<Integer> temp,int[] nums){
        if(temp.size() == nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(temp.contains(nums[i])) continue;
            temp.add(nums[i]);
            backTrace(result,temp,nums);
            temp.remove(temp.size()-1);
        }
    }

    @Test
    public void fun(){
        int[] nums = {1,2,3};
        System.out.println(permute(nums));
    }
}
