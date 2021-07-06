package preday;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *
 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 在杨辉三角中，每个数是它左上方和右上方的数的和。
 */
public class No118 {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if(numRows <= 0){
            return ans;
        }
        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            if(i >= 2){
                for (int j = 1; j <= i - 1 && ans.size() > 1; j++) {
                    List<Integer> pre = ans.get(ans.size() - 1);
                    list.add(pre.get(j)+pre.get(j-1));
                }
            }
            if(i >= 1){
                list.add(1);
            }
            ans.add(list);
        }
        return ans;
    }

    @Test
    public void test(){
        System.out.println(generate(5));
    }
}
