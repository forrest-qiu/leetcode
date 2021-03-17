package No17;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class No17 {

    public List<String> letterCombinations(String digits){
        Map<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        List<String> list = new ArrayList<>();
        fun(list,digits,0,new StringBuffer(),map);
        return list;
    }

    public void fun(List<String> result,String digits,int index,StringBuffer x,Map<Character,String> map){
        if(index == digits.length()){
            result.add(x.toString());
        }else{
            char digit = digits.charAt(index);
            String letter = map.get(digit);
            for (int i = 0; i < letter.length(); i++) {
                x.append(letter.charAt(i));
                fun(result,digits,index+1,x,map);
                x.deleteCharAt(index);
            }

        }
    }

    @Test
    public  void test(){
        System.out.println(letterCombinations("23"));
    }

}
