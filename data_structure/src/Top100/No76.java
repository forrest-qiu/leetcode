package Top100;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
 *
 */
public class No76 {

    //暴力法
    public String minWindow(String s, String t) {
        int a = s.length();
        int b = t.length();
        if(a==0||a< b){
            return "";
        }
        TreeMap<Integer,String> map = new TreeMap<>();
        for (int i = 0; i <= a - b; i++) {
            int j = i+b;
            while(j<=a){
                String sub = s.substring(i, j);
                if(containSub(sub,t)){
                    map.put(sub.length(),sub);
                    break;
                }
                j++;
            }
        }
        if(map.size()>0){
            return map.firstEntry().getValue();
        }else{
            return "";
        }

    }

    public boolean containSub(String parent,String sub){
        if(parent.length()<sub.length()){
            return false;
        }
        for (int i = 0; i < sub.length(); i++) {
            int temp = parent.length();
            int index = parent.indexOf(sub.charAt(i));
            if(index>-1&&index < temp - 1){
                parent = parent.substring(0,index).concat(parent.substring(index+1));
            }else if(index == temp -1){
                parent = parent.substring(0,index);
            }else{
                return false;
            }
            int temp2 =  parent.length();
            if(temp==temp2){
                return false;
            }
        }
        return true;
    }

    /**
     * 滑块法
     * @param s
     * @param t
     * @return
     */
    public String minWindow2(String s, String t) {
       if(s==null||t==null||s.length()*t.length()==0||t.length()>s.length()){
           return "";
       }
       Map<Character,Integer> need = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            if(need.containsKey(t.charAt(i))){
                need.put(t.charAt(i),need.get(t.charAt(i)+1));
            }else{
                need.put(t.charAt(i),1);
            }
        }
        int left = 0,right = left + t.length(),sLen = s.length(),tLen = t.length();
        while(right<sLen){
            char c = s.charAt(right);
            if(need.get(c)>0){
                tLen--;
                //找到了就减一
                need.put(c,need.get(c)-1);
            }
            if(tLen==0){
                while(left<right&&need.get(s.charAt(left))<0){
                    need.put(s.charAt(left),need.get(s.charAt(left))+1);
                    left++;
                }
            }
            right++;
        }
       return "";
    }


    @Test
    public void fun(){
        String a = "ADOBECODEBANC";
        String b = "ABC";
        System.out.println(minWindow2(a,b));
    }

}
