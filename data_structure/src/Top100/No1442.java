package Top100;

import org.junit.Test;

import java.util.*;

/**
 * 给你一个整数数组 arr 。
 *
 * 现需要从数组中取三个下标 i、j 和 k ，其中 (0 <= i < j <= k < arr.length) 。
 *
 * a 和 b 定义如下：
 *
 * a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
 * b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
 * 注意：^ 表示 按位异或 操作。
 *
 * 请返回能够令 a == b 成立的三元组 (i, j , k) 的数目。
 *
 */
public class No1442 {

    /**
     * S[i] = S[k+1]
     * S[i]表示前i个元素的异或和
     * ​
     * @param arr
     * @return
     */
    public int countTriplets(int[] arr) {
        int len = arr.length;
        int ans = 0;
        for(int i = 0; i < len - 1; i ++){
            int sum = 0;
            for(int k = i; k < len ; k ++){
                sum ^= arr[k];
                if (sum == 0 && k > i) {
                    ans += (k - i);
                }
            }
        }
        return ans;
    }


    @Test
    public void test(){
        int[] arr = {2,3,1,6,7};
        System.out.println(countTriplets(arr));
    }
}
