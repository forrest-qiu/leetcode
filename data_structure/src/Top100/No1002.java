package Top100;

import java.util.ArrayList;
import java.util.List;

/**
 *
 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。

 你可以按任意顺序返回答案
 */
public class No1002 {

    public List<String> commonChars(String[] words) {
        int n = words.length;
        int[][] f = new int[n][26];
        for (int i = 0; i < n; i++) {
            String temp = words[i];
            for (int j = 0; j < temp.length(); j++) {
                f[i][temp.charAt(j)-'a']++;
            }
        }
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if(min==0){
                    break;
                }
                min = Math.min(min,f[j][i]);
            }
            if(min>0){
                for (int j = 0; j < min; j++) {
                    ans.add((char)('a'+i)+"");
                }
            }
        }
        return ans;
    }

    public List<String> commonChars2(String[] words) {
        int n = words.length;
        int[] f = new int[26];  //维护每一个字母在每个字符串中出现的最小次数
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            int count = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                String temp = words[j];
                int x = 0;
                for (int k = 0; k < temp.length(); k++) {
                    if(temp.charAt(k)==(i+'a')){
                        x++;
                    }
                }
                count = Math.min(count,x);
            }

        }

        return ans;
    }

}
