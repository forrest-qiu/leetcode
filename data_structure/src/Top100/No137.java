package Top100;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 *
 */
public class No137 {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for (Integer key : map.keySet()) {
            if(map.get(key)==1){
                return key;
            }
        }
        return 0;
    }


    //32位二进制累加，出现过3次的数，在第i位上对3取余必为0，否则该位是我们要找的只出现过一次的数
    public int singleNumber2(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; ++i) {
            int total = 0;
            for (int num: nums) {
                total += ((num >> i) & 1);
            }
            if (total % 3 != 0) {
                ans |= (1 << i);
            }
        }
        return ans;
    }
}
