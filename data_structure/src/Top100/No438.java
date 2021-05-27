package Top100;

import org.junit.Test;

import java.util.*;

/**
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 *
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 *
 */
public class No438 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int len = p.length();
        int n  = s.length();
        if(n<len){
            return ans;
        }
        Set<String> set = new HashSet<>();
        set.add(p);
        for (int i = 0; i <= s.length() - len; i++) {
            String temp = s.substring(i,i+len);
            if(set.contains(temp)){
                ans.add(i);
            }else{
                if(isSame(temp,p)){
                    ans.add(i);
                    set.add(temp);
                }
            }
        }
        return ans;
    }

    public boolean isSame(String a,String b){
        for (int i = 0; i < a.length(); i++) {
            b = b.replaceFirst(a.charAt(i)+"","");
        }
        return b.length()==0;
    }


    /**
     * 使用双指针加滑动窗口
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        Map<Character,Integer> smap = new HashMap<>();
        Map<Character,Integer> pmap = new HashMap<>();
        for (int i = 0; i < p.length(); i++) {
            pmap.put(p.charAt(i),pmap.getOrDefault(p.charAt(i),0)+1);
        }
        int left = 0,right = 0,count = 0,len = p.length();
        while(right<s.length()){
            char c = s.charAt(right);
            smap.put(c,smap.getOrDefault(c,0)+1);
            //如果 p 中包含当前字符，且s的窗口中该字符出现次数不足，则该字符可以作为候选字符，count加一
            if(pmap.containsKey(c)&&smap.get(c)<=pmap.get(c)){
                count++;
            }
            if(count==len){
                ans.add(left);
            }
            if(right-left+1>=len){
                char leftChar = s.charAt(left);
                //判断收缩的这个字符是否是候选字符，是则count减一
                if(pmap.containsKey(leftChar)&&pmap.get(leftChar)>=smap.get(leftChar)){
                    count--;
                }
                //窗口收缩一个字符
                smap.put(leftChar,smap.getOrDefault(leftChar,0)-1);
                left++;
            }
            right++;

        }
        return ans;
    }

    @Test
    public void test(){
        System.out.println(findAnagrams2("cbaebabacd","abc"));
        /**
         * "ababababab"
         * "aab"
         */
        System.out.println(findAnagrams2("aa","bb"));
    }

}
