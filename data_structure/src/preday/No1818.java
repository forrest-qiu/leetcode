package preday;

import org.junit.Test;

import java.util.Arrays;

public class No1818 {

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        final int MOD = 1000000007;
        int n = nums1.length;
        int[] rec = new int[n];
        System.arraycopy(nums1, 0, rec, 0, n);
        Arrays.sort(rec);
        int sum = 0, maxn = 0;
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            sum = (sum + diff) % MOD;
            int j = binarySearch(rec, nums2[i]);
            if (j < n) {
                maxn = Math.max(maxn, diff - (rec[j] - nums2[i]));
            }
            if (j > 0) {
                maxn = Math.max(maxn, diff - (nums2[i] - rec[j - 1]));
            }
        }
        return (sum - maxn + MOD) % MOD;
    }

    public int binarySearch(int[] rec, int target) {
        int low = 0, high = rec.length - 1;
        if (rec[high] < target) {
            return high + 1;
        }
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (rec[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }


    @Test
    public void test(){
//       int[] nums1 = {1,7,5};
//       int[] nums2 = {2,3,5};
//       int[] nums1 = {1,28,21};
//       int[] nums2 = {9,21,20};
       int[] nums1 = {1,10,4,4,2,7};
       int[] nums2 = {9,3,5,1,7,4};
       System.out.println(minAbsoluteSumDiff(nums1,nums2));
    }
}
