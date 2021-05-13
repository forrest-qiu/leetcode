package Top100;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * 一只青蛙想要过河。 假定河流被等分为若干个单元格，并且在每一个单元格内都有可能放有一块石子（也有可能没有）。 青蛙可以跳上石子，但是不可以跳入水中。
 *
 * 给你石子的位置列表 stones（用单元格序号 升序 表示）， 请判定青蛙能否成功过河（即能否在最后一步跳至最后一块石子上）。
 *
 * 开始时， 青蛙默认已站在第一块石子上，并可以假定它第一步只能跳跃一个单位（即只能从单元格 1 跳至单元格 2 ）。
 *
 * 如果青蛙上一步跳跃了 k 个单位，那么它接下来的跳跃距离只能选择为 k - 1、k 或 k + 1 个单位。 另请注意，青蛙只能向前方（终点的方向）跳跃。
 *
 */
public class No403 {
    boolean ans = false;
    //key为值，value为索引
    HashMap<Integer,Integer> map = new HashMap<>();
    public boolean canCross(int[] stones) {
        int n = stones.length;
        if(n<=1){
            return true;
        }
        if(n == 2){
            return stones[1] <= 1;
        }
        for (int i = 0; i < n; i++) {
            map.put(stones[i],i);
        }
        dfs(stones,1,1);
        return ans;
    }

    public void dfs(int[] stones,int k,int curr_index){
        if(curr_index>stones.length-1||ans){
            return;
        }
        if(curr_index==stones.length-1){
            ans = true;
            return;
        }
        int curr = stones[curr_index];
        for (int i = k-1; i <= k+1 ; i++) {
            if(i>0){
                Integer j = map.get(curr+i);
                if(j!=null&&!ans){
                    dfs(stones,i,j);
                }
            }
        }
    }

    @Test
    public void test(){
        int[] stones = {0,1,3,5,6,8,12,17};
        System.out.println(canCross(stones));
    }
}
