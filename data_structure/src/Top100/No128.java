package Top100;

import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * 给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
 */
public class No128 {
    public int longestConsecutive(int[] nums) {
        int len = 1;
        int maxLen = 0;
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int i = 0;
        int temp = 0;
        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()){
                int x = iterator.next();
                if(i==0){
                    temp = x;
                    i++;
                    continue;
                }
                if(x == temp+1){
                    len++;
                }else{
                    maxLen = Math.max(len,maxLen);
                    len = 1;
                }
                temp = x;
        }
        return Math.max(len,maxLen);
    }

    @Test
    public void test(){
//        int[] nums = {100,4,200,1,3,2};
//        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        int[] nums = {1,2,0,1};
        System.out.println(longestConsecutive(nums));
    }
}
