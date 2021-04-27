package Top100;

import org.junit.Test;

import java.util.*;

/**
 * 给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[j]) 都应当满足：
 * answer[i] % answer[j] == 0 ，或
 * answer[j] % answer[i] == 0
 * 如果存在多个有效解子集，返回其中任何一个均可。
 *
 */
public class No368 {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        LinkedList<Integer> stack = new LinkedList<>();
        int curr = nums.length;
        for (int i = nums.length-1; i >= 0 ; i--) {
            if(i < nums.length-1){
                if(!(nums[i]%nums[curr] == 0 || nums[curr]%nums[i] == 0)){
                    continue;
                }
            }
            stack.addFirst(nums[i]);
            curr--;
        }
        return stack;
    }

    public List<Integer> largestDivisibleSubset2(int[] nums) {
        List<LinkedList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            LinkedList<Integer> list = new LinkedList<Integer>();
            list.add(nums[i]);
            for (int j = i+1; j < nums.length; j++) {
                dfs(nums,j,list,result);
            }
            result.add(list);
        }
        TreeMap<Integer,List<Integer>> map = new TreeMap<>();
        for (int i = 0; i < result.size(); i++) {
            map.put(result.get(i).size(),result.get(i));
        }
        return map.lastEntry().getValue();
    }

    //应该是使用回溯
    public void dfs(int[] nums,int index,LinkedList<Integer> path,List<LinkedList<Integer>> result){
        if(index == nums.length){
            result.add(path);
            return;
        }
        if(path.size()>0&&(nums[index]%path.peekLast()==0||path.peekLast()%nums[index]==0)){
            path.addLast(nums[index]);
        }
    }

    public List<Integer> largestDivisibleSubset3(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<LinkedList<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            LinkedList<Integer> temp = new LinkedList<>();
            temp.add(nums[i]);
            for (int j = i +1; j < n; j++) {
                if(nums[j]%temp.getLast()==0||temp.getLast()%nums[j]==0){
                    temp.add(nums[j]);
                }
            }
            result.add(temp);
        }

        TreeMap<Integer,List<Integer>> map = new TreeMap<>();
        for (int i = 0; i < result.size(); i++) {
            map.put(result.get(i).size(),result.get(i));
        }
        return map.lastEntry().getValue();

    }

    @Test
    public void fun(){
        int[] nums = {2,3,4,8};
//        int[] nums = {1,2,3};
//        int[] nums = {4,8,10,240};
//        int[] nums = {3,4,16,8};
        System.out.println(largestDivisibleSubset3(nums));
    }
}
