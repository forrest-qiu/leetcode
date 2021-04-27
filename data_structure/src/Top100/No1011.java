package Top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

/**
 * 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 *
 * 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。
 *
 * 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。
 *
 *  
 */
public class No1011 {

    public int shipWithinDays(int[] weights, int D) {
        int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum();
        while(left<right){
            int mid = (left+right)/2;
            int need = 1,cur = 0;
            for (int weight : weights) {
                if(cur+weight>mid){
                    need++;
                    cur=0;
                }
                cur += weight;
            }
            if(need <= D){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }
}
