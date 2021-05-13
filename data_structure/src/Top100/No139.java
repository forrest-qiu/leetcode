package Top100;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词
 */
public class No139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    @Test
    public void test(){
//        String s = "leetcode";String[] wordDict = {"leet", "code"};
//        String s = "applepenapple";String[] wordDict = {"apple", "pen"};
//        String s = "catsandog";String[] wordDict = {"cats", "dog", "sand", "and", "cat"};
        //"cars"
        //["car","ca","rs"]
        String s = "cars";String[] wordDict = {"car","ca","rs"};
        System.out.println(wordBreak(s, Arrays.asList(wordDict)));
    }
}
