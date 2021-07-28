package preday;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个数组 target ，包含若干 互不相同 的整数，以及另一个整数数组 arr ，arr 可能 包含重复元素。
 *
 * 每一次操作中，你可以在 arr 的任意位置插入任一整数。比方说，如果 arr = [1,4,1,2] ，那么你可以在中间添加 3 得到 [1,4,3,1,2] 。你可以在数组最开始或最后面添加整数。
 *
 * 请你返回 最少 操作次数，使得 target 成为 arr 的一个子序列。
 *
 * 一个数组的 子序列 指的是删除原数组的某些元素（可能一个元素都不删除），同时不改变其余元素的相对顺序得到的数组。比方说，[2,7,4] 是 [4,2,3,7,2,1,4] 的子序列（加粗元素），但 [2,4,2] 不是子序列。
 *
 */
public class No1713 {

    public int minOperations(int[] target, int[] arr) {
        int max_count = 0;
        //找出target 和 arr 最小相同子序列
        for (int i = 0; i < target.length; i++) {
            int index = 0;
            int count = 0;
            int j = i;
            while (( index = findIndex(index, arr, target[j])) > -1 ){
                count++;
                if(j == target.length-1||index == arr.length -1){
                    break;
                }
                index++;
                j++;
            }
            max_count = Math.max(count,max_count);
            if(target.length-i<max_count){
                break;
            }
        }
        return target.length - max_count;
    }

    public int findIndex(int start,int[] arr,int target){
        for (int i = start; i < arr.length; i++) {
            if(target == arr[i]){
                return i;
            }
        }
        return -1;
    }

    @Test
    public void test(){
//        int[] target = {5,1,3};
//        int[] arr = {9,4,2,3,4};
//        int[] target = {6,4,8,1,3,2};
//        int[] arr = {4,7,6,2,3,8,6,1};
        int[] target = {16,7,20,11,15,13,10,14,6,8};
        int[] arr  = {11,14,15,7,5,5,6,10,11,6};
        System.out.println(minOperations(target,arr));
    }
}
