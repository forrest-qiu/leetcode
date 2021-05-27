package Top100;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 *
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 *
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内
 *
 */
public class No448 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[Math.abs(nums[i])-1] *= -1;
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(nums[i]>0){
                ans.add(i);
            }
        }
        return ans;
    }
}
