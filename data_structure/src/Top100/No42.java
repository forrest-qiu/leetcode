package Top100;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 */
public class No42 {

    public int trap(int[] height) {
        int leftMax = 0;
        int rightMax = 0;
        int left = 0;
        int right = height.length -1;
        int result = 0;
        while(left < right){
            leftMax = Math.max(leftMax,height[left]);
            rightMax = Math.max(rightMax,height[right]);
            if(height[left]<height[right]){
                result += leftMax - height[left];
                left++;
            }else{
                result += rightMax - height[right];
                right--;
            }
        }
        return result;
    }
}
