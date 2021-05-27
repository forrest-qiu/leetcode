package Top100;

import org.junit.Test;

/**
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 */
public class No739 {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            int day = 0;
            for (int j = i+1; j < temperatures.length ; j++) {
                if(temperatures[i]<temperatures[j]){
                    day = j - i;
                    break;
                }
            }
            ans[i] = day;
        }
        return ans;
    }

    public int[] dailyTemperatures2(int[] temperatures) {
        int len = temperatures.length;
        int[] ans = new int[len];
        for (int i = len-1; i >=0 ; i++) {

        }
        return ans;
    }

    @Test
    public void test(){
        int[] temperatures = {89,62,70,58,47,47,46,76,100,70}; //[8,1,5,4,3,2,1,1,0,0]
        System.out.println(dailyTemperatures(temperatures));
    }
}
