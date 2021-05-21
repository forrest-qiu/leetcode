package Top100;

import org.junit.Test;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值
 *
 */
public class No239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int i = 0,j = k-1;
        int[] ans = new int[nums.length-k+1];
        Queue<Integer> queue = new LinkedList<>();
        for (int l = 0; l < k; l++) {
            queue.offer(nums[l]);
        }
        while(j<nums.length){
            ans[i] = queue.stream().mapToInt(Integer::intValue).max().getAsInt();
            j++;
            i++;
            if(j==nums.length){
                break;
            }
            queue.poll();
            queue.offer(nums[j]);
        }
        return ans;
    }

    public int[] maxSlidingWindow2(int[] nums,int k){
        if(nums==null||nums.length<2) return nums;
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数按从大到小排序
        LinkedList<Integer> list = new LinkedList();
        // 结果数组
        int[] result = new int[nums.length-k+1];
        for(int i=0;i<nums.length;i++){
            // 保证从大到小 如果前面数小 弹出
            while(!list.isEmpty()&&nums[list.peekLast()]<=nums[i]){
                list.pollLast();
            }
            // 添加当前值对应的数组下标
            list.addLast(i);
            // 初始化窗口 等到窗口长度为k时 下次移动在删除过期数值
            if(list.peek()<=i-k){
                list.poll();
            }
            // 窗口长度为k时 再保存当前窗口中最大值
            if(i-k+1>=0){
                result[i-k+1] = nums[list.peek()];
            }
        }
        return result;
    }
    @Test
    public void test(){
        int[] nums = {1,3,-1,-3,5,3,6,7};int k = 3;
        System.out.println(maxSlidingWindow(nums,k));
    }
}
