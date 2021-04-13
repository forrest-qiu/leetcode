package No18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No39 {

    /**
     * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     *
     * candidates 中的数字可以无限制重复被选取。
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        backTrace(result,new ArrayList<>(),target,0,candidates);
        return result;
    }

    public void backTrace(List<List<Integer>> result,List<Integer> temp,int target,int index,int[] candidates){
        if(target==0){
            if(!temp.isEmpty()){
                result.add(new ArrayList<>(temp));
            }
            return;
        }
        for (int i = index; i < candidates.length&&target-candidates[i]>=0 ; i++) {
            temp.add(candidates[i]);
            backTrace(result,temp,target-candidates[i],i,candidates);
            temp.remove(temp.size()-1);
        }
    }

    /**
     * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     *
     * candidates 中的每个数字在每个组合中只能使用一次。
     *
     * @param result
     * @param temp
     * @param target
     * @param index
     * @param candidates
     */
    public void backTrace2(List<List<Integer>> result,List<Integer> temp,int target,int index,int[] candidates){
        if(target==0){
            if(!temp.isEmpty()){
                result.add(new ArrayList<>(temp));
            }
            return;
        }
        for (int i = index; i < candidates.length&&target-candidates[i]>=0 ; i++) {
            if(i>index&&candidates[i]==candidates[i-1]){
                continue;
            }
            temp.add(candidates[i]);
            backTrace(result,temp,target-candidates[i],i+1,candidates);
            temp.remove(temp.size()-1);
        }
    }

}
