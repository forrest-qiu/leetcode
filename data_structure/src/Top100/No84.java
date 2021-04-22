package Top100;

import org.junit.Test;

import java.util.Stack;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 *
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 */
public class No84 {

    public int largestRectangleArea(int[] heights) {
        int length = heights.length;
        int[] left = new int[length];
        int[] right = new int[length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            while(!stack.empty()&&heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            left[i] = (stack.isEmpty()?-1:stack.peek());
            stack.push(i);
        }
        stack.clear();
        for (int i = length -1; i > -1; i--) {
            while(!stack.empty()&&heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            right[i] = (stack.isEmpty()? length :stack.peek());
            stack.push(i);
        }
        int result = 0;
        for (int i = 0; i < length; i++) {
            result = Math.max((right[i]-left[i]-1)*heights[i],result);
        }
        return result;
    }

    public int min(int[] nums,int start,int end){
        int result = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            result = Math.min(nums[i],result);
        }
        return result;
    }

    @Test
    public void fun(){
        int[] x = {5,5,1,7,1,1,5,2,7,6};
        System.out.println(largestRectangleArea(x));
    }
}
