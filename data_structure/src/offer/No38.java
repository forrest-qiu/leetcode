package offer;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 *
 *
 *
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素
 */
public class No38 {

    private Set<String> set = new HashSet<>();

    private boolean[] visit;

    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        visit = new boolean[s.length()];
        Arrays.fill(visit,false);
        Arrays.sort(chars);
        dfs(chars,0,s.length(),new StringBuffer());
        return set.toArray(new String[]{});
    }


    public void dfs(char[] s,int start,int len,StringBuffer sub){
        if(start==len){
            set.add(sub.toString());
            return;
        }
        for (int i = 0; i < len; i++) {
            if(visit[i]||(i>0&&!visit[i-1]&&s[i]==s[i-1])){
                continue;
            }
            visit[i] = true;
            sub.append(s[i]);
            dfs(s,start+1,len,sub);
            visit[i] = false;
            sub.deleteCharAt(sub.length()-1);
        }
    }


    @Test
    public void test(){
        String s = "abc";
        System.out.println(permutation(s));
    }

}
