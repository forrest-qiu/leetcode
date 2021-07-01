package Top100;

public class No447 {

    /**
     * 两个整数的 汉明距离 指的是这两个数字的二进制数对应位不同的数量。
     *
     * 计算一个数组中，任意两个数之间汉明距离的总和。
     * @param nums
     * @return
     */
    public int totalHammingDistance(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                ans += Integer.bitCount(nums[i]^nums[j]);
            }
        }
        return ans;
    }

    public int totalHammingDistance2(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 31; i++) {
            //二进制，从右到左，累计汉明距离,统计0和1的个数
            int[] count = new int[2];
            for (int j = 0; j < nums.length; j++) {
                count[nums[j]&1]++;
                nums[j] = nums[j] >> 1;
            }
            ans += count[0]*count[1];
        }
        return ans;
    }
}
