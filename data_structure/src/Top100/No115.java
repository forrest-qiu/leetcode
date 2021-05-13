package Top100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串 s 和一个字符串 t ，计算在 s 的子序列中 t 出现的个数。
 *
 * 字符串的一个 子序列 是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。（例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 *
 * 题目数据保证答案符合 32 位带符号整数范围。
 *
 */
public class No115 {

//    public List<List<Integer>> paths = new ArrayList<>();
    int count = 0;
    public int numDistinct(String s, String t) {
        if(s.length()<t.length()){
            return 0;
        }
        dfs(s.toCharArray(),t,-1,0,new ArrayList<>());
        return count;
    }

    public void dfs(char[] s,String t,int i,int j,List<Integer> path){
        if(i > s.length || j > t.length()){
            return;
        }
        if(path.size() == t.length()){
            count++;
            return;
        }
        for (int k = i + 1; k < s.length; k++) {
            if(s[k] == t.charAt(j)){
                path.add(k);
                dfs(s,t,k,j+1,path);
                path.remove(path.size()-1);
            }
        }
    }

    public int numDistinct2(String s, String t) {
        int m = s.length(), n = t.length();
        if (m < n) {
            return 0;
        }
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][n] = 1;
        }
        for (int i = m - 1; i >= 0; i--) {
            char sChar = s.charAt(i);
            for (int j = n - 1; j >= 0; j--) {
                char tChar = t.charAt(j);
                if (sChar == tChar) {
                    dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
                } else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }
        return dp[0][0];
    }

    @Test
    public void test(){
//        String s = "rabbbit", t = "rabbit";
        String s = "babgbag", t = "bag";
        System.out.println(numDistinct(s,t));
    }
}
