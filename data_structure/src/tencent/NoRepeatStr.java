package tencent;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NoRepeatStr {

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        TreeMap<Integer,String> map = new TreeMap<>();
        for (int i = 0;i < chars.length; i++) {
            int len = 1;
            int j = i;
            char temp = chars[j];
            StringBuffer str = new StringBuffer(temp+"");
            while( j+1 < chars.length && !str.toString().contains(chars[j+1]+"")){
                len ++;
                temp = chars[j+1];
                j++;
                str.append(temp);
            }
            map.put(len,str.toString());
        }
        return map.size() == 0 ? 0:map.lastKey();
    }


    public int lengthOfLongestSubstring2(String s) {
        if(s.length() <= 1){
            return s.length();
        }
        char[] chars = s.toCharArray();
        HashSet<Character> set = new HashSet<>();
        set.add(chars[0]);
        int right = 1;
        int max = 1;
        for (int i = 0; i < chars.length ; i++) {
            if(i != 0){
                set.remove(chars[i-1]);
            }
            while ( right <= chars.length - 1 && !set.contains(chars[right])){
                set.add(chars[right]);
                right ++;
            }
            max = Math.max(set.size(),max);
        }
        return max;
    }


    @Test
    public void fun(){
        String s = "au";
//        String s = " ";
        System.out.println(lengthOfLongestSubstring2(s));
    }

}
