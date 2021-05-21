package Top100;

/**
 * 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 *示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。
 *
 * 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 * 进阶：
 * 你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。）
 *
 */
public class No238 {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        //s[i]表示0~i-1的元素乘积
        int[] s = new int[n];
        s[0] = 1;
        //f[i]表示i+1~n的元素乘积
        int[] f = new int[n];
        f[n-1] = 1;
        for (int i = 1; i < n; i++) {
           s[i] = s[i-1]*nums[i-1];
        }
        for (int i = n-2; i >= 0 ; i--) {
            f[i] = f[i+1]*nums[i+1];
        }
        for (int i = 0; i < n; i++) {
            ans[i] = s[i]*f[i];
        }
        return ans;
    }
}
