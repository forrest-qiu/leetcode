package Top100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 在两条独立的水平线上按给定的顺序写下 nums1 和 nums2 中的整数。
 *
 * 现在，可以绘制一些连接两个数字 nums1[i] 和 nums2[j] 的直线，这些直线需要同时满足满足：
 *
 *  nums1[i] == nums2[j]
 * 且绘制的直线不与任何其他连线（非水平线）相交。
 * 请注意，连线即使在端点也不能相交：每个数字只能属于一条连线。
 *
 * 以这种方法绘制线条，并返回可以绘制的最大连线数。
 *
 */
public class No1035 {

    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        List<int[]> list = new ArrayList<>();
        int ans = Integer.MIN_VALUE;
        int len1 = nums1.length;
        int len2 = nums2.length;
        boolean[] f2 = new boolean[len2];
        for (int i = 0; i < len1; i++) {
            Arrays.fill(f2,false);
            for (int j = i; j < len1; j++) {
                int index2 = findIndex(nums2,f2,nums1[j]);
                if(index2>=0&&!hasCross(list,new int[]{j,index2})){
                    list.add(new int[]{j,index2});
                    f2[index2] = true;
                }
            }
            ans = Math.max(list.size(),ans);
            list.clear();
            if(len1-i<ans){
                break;
            }
        }
        return ans;
    }

    //查找目标值
    public int findIndex(int[] nums,boolean[] f,int target){
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==target&&!f[i]){
                return i;
            }
        }
        return -1;
    }

    //是否有交叉
    public boolean hasCross(List<int[]> list,int[] target){
        for (int[] ints : list) {
            if((target[0]-ints[0])*(target[1]-ints[1])<=0){
                return true;
            }
        }
        return false;
    }


    public int maxUncrossedLines2(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[][] dp = new int[len1+1][len2+1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if(nums1[i-1]==nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1] +1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[len1][len2];
    }

    @Test
    public void test(){
//        int[] nums1 = {2,5,1,2,5};
//        int[] nums2 = {10,5,2,1,5,2};
//        int[] nums1 = {1,3,7,1,7,5};
//        int[] nums2 = {1,9,2,5,1};
        int[] nums1 = {2,1};
        int[] nums2 = {1,2,1,3,3,2};
        System.out.println(maxUncrossedLines2(nums1,nums2));
    }

}
