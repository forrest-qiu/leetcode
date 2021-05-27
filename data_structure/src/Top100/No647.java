package Top100;

/**
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 */
public class No647 {

    public int countSubstrings(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {
                if(isSub(s.substring(i,j))){
                    ans++;
                }
            }
        }
        return ans;
    }

    public boolean isSub(String x){
        for (int i = 0; i < x.length()/2; i++) {
            if(x.charAt(i)!=x.charAt(x.length()-i-1)){
                return false;
            }
        }
        return true;
    }
}
