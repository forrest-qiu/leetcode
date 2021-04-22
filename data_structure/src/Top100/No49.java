package Top100;

import java.util.*;

/**
 *
 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串
 */
public class No49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> result = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String key = getSortString(strs[i]);
            if(result.containsKey(key)){
                result.get(getSortString(key)).add(strs[i]);
            }else{
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                result.put(key,list);
            }
        }
        return new ArrayList<List<String>>(result.values());
    }

    public String getSortString(String s){
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    /**
     * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if(x == 0){
            return 0;
        }
        if(Math.abs(x) == 1){
            return x;
        }
        double result = x;
        for (int i = 0; i < Math.abs(n); i++) {
            result = x * result;
        }
        if(n == 0){
            return 1;
        }
        return n>0?result:1.0d/result;
    }



}
