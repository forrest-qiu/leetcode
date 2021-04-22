package Top100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 使用下面描述的算法可以扰乱字符串 s 得到字符串 t ：
 * 如果字符串的长度为 1 ，算法停止
 * 如果字符串的长度 > 1 ，执行下述步骤：
 * 在一个随机下标处将字符串分割成两个非空的子字符串。即，如果已知字符串 s ，则可以将其分成两个子字符串 x 和 y ，且满足 s = x + y 。
 * 随机 决定是要「交换两个子字符串」还是要「保持这两个子字符串的顺序不变」。即，在执行这一步骤之后，s 可能是 s = x + y 或者 s = y + x 。
 * 在 x 和 y 这两个子字符串上继续从步骤 1 开始递归执行此算法。
 * 给你两个 长度相等 的字符串 s1 和 s2，判断 s2 是否是 s1 的扰乱字符串。如果是，返回 true ；否则，返回 false 。
 *
 */
public class No87 {
    List<String> list = new ArrayList<>();
    public boolean isScramble(String s1, String s2) {
        int length = s1.length();
        if(length != s2.length()){
            return false;
        }
        Map<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            char c = s1.charAt(i);
            char c1 = s2.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
            map.put(c1,map.getOrDefault(c1,0)-1);
        }
        for (Character character : map.keySet()) {
            if(map.get(character)!=0){
                return false;
            }
        }
        for (int i = 1; i < length; i++) {
            if(
                    (isScramble(s1.substring(0,i),s2.substring(0,i))&&isScramble(s1.substring(i),s2.substring(i)))
                            ||
                    (isScramble(s1.substring(0,i),s2.substring(length -i))&&isScramble(s1.substring(i),s2.substring(0, length -i)))
            ){
                return true;
            }
        }
        return false;
    }


    public boolean isScramble2(String s1, String s2) {
        // 长度不等，必定不能变换
        if (s1.length() != s2.length()) {
            return false;
        }
        // 长度相等，先特判下
        if (s1.equals(s2)) {
            return true;
        }
        // 看一下字符个数是否一致，不同直接return false
        int n = s1.length();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            map.put(c1, map.getOrDefault(c1, 0) + 1);
            map.put(c2, map.getOrDefault(c2, 0) - 1);
        }
        for (Character key : map.keySet()) {
            if (map.get(key) != 0) {
                return false;
            }
        }

        // 相同的话，开始判断判断，满足一个就能 return true
        for (int i = 1; i < n; i++) {
            boolean flag =
                    // S1 -> T1，S2 -> T2
                    (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) ||
                            // S1 -> T2，S2 -> T1
                            (isScramble(s1.substring(0, i), s2.substring(n - i)) && isScramble(s1.substring(i), s2.substring(0, s2.length() - i)));
            if (flag) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void fun(){
        System.out.println(isScramble2("great","rgeat"));
    }
}
