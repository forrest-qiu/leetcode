package Top100;

import org.junit.Test;

/**
 * 给定三个字符串 s1、s2、s3，请你帮忙验证 s3 是否是由 s1 和 s2 交错 组成的。
 *
 * 两个字符串 s 和 t 交错 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：
 *
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * 交错 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
 * 提示：a + b 意味着字符串 a 和 b 连接。
 *
 */
public class No97 {
    //动态规划
    public boolean isInterleave(String s1, String s2, String s3) {
        int a = s1.length();
        int b = s2.length();
        int c = s3.length();
        if(c != a + b){
            return false;
        }
        boolean[][] f = new boolean[a + 1][b + 1];

        f[0][0] = true;
        for (int i = 0; i <= a; ++i) {
            for (int j = 0; j <= b; ++j) {
                int p = i + j - 1;
                if (i > 0) {
                    f[i][j] = f[i][j] || (f[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p));
                }
                if (j > 0) {
                    f[i][j] = f[i][j] || (f[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                }
            }
        }
        return f[a][b];
    }

    @Test
    public void fun(){
//        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
//        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc";
        String s1 = "aa", s2 = "ab", s3 = "aaba";
        System.out.println(isInterleave(s1,s2,s3));
    }
}
