package Top100;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *。
 */
public class No169 {

    public int majorityElement(int[] nums) {
        int ans = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(count==0){
                ans = nums[i];
            }
            count += (nums[i]==ans)?1 : -1;
        }
        return ans;
    }
}
