package No18;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
 *
 */
public class No56 {
    public int[][] merge(int[][] intervals) {
        if(intervals==null){
            return null;
        }
        int length = intervals.length;
        if(length == 1){
            return intervals;
        }
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);
        int[][] result = new int[length][];
        result[0] = intervals[0];
        int current = 1;
        for (int i = 1; i < length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            int pre_start = result[current-1][0];
            int pre_end = result[current-1][1];
            if(pre_end>=start&&pre_start<=end){  //如果有交集，合并当前元素
                int x = Math.min(pre_start,start);
                int y = Math.max(end,pre_end);
                result[current-1][0] = x;
                result[current-1][1] = y;
            }else{
               result[current] = intervals[i];
               current++;
            }
        }
        return Arrays.copyOfRange(result,0,current);
    }


    @Test
    public void fun(){
        int[][] xx = {{1,4},{0,2},{3,5}};
        System.out.println(merge(xx));
    }

}
