package Top100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 回文串 是正着读和反着读都一样的字符串。
 */
public class No131 {
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> partition(String s) {
        dfs(s,0,new ArrayList<String>());
        return ans;
    }


    public void dfs(String s,int start,List<String> path){
        if(start == s.length()){
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = start+1; i <= s.length(); i++) {
            String sub = s.substring(start,i);
            if(isPalindrome(sub)){
                path.add(sub);
                dfs(s,i,path);
                path.remove(path.size()-1);
            }
        }
    }

    public boolean isPalindrome(String s){
        if(s.length()==1){
            return true;
        }
        for (int i = 0; i < s.length()/2; i++) {
            if(s.charAt(i)!=s.charAt(s.length()-1-i)){
                return false;
            }
        }
        return true;
    }

    @Test
    public void test(){
        System.out.println(partition("aab"));
    }

}
