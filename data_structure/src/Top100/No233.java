package Top100;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数 n，计算所有小于等于 n 的非负整数中数字 1 出现的个数。
 */
public class No233 {
    Map<Integer,Integer> map = new HashMap<>();

    public int countDigitOne(int n) {
        map.put(1,1);
        int ans = 0;
        for (int i = 0; i <= n; i++) {
            ans += getOne(i);
        }
        return ans;
    }

    public int getOne(int n){
        if(n<10){
            return map.getOrDefault(n,0);
        }
        int temp = n / 10;
        int b = n%10;
        Integer x = map.getOrDefault(temp, 0);
        if(b==1){
            x = x + 1;
        }
        if(x>0){
            map.put(n,x);
        }
        return x;
    }


    public int countDigitOne2(int n) {
        int countr = 0;
        for (long i = 1; i <= n; i *= 10) {
            long divider = i * 10;
            countr += (n / divider) * i + Math.min(Math.max(n % divider - i + 1, 0l), i);
        }
        return countr;
    }

    @Test
    public void test(){
        System.out.println(countDigitOne2(13));
    }
}
