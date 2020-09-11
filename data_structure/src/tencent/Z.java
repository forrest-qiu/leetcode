package tencent;

import org.junit.Test;

import java.util.Map;
import java.util.TreeMap;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Z {

    public String convert(String s, int numRows) {
        TreeMap<Integer,StringBuffer> treeMap = new TreeMap<>();
        char[] chars = s.toCharArray();
        int f = 0;
        int i = 0;
        int index = 0;
        while(i<chars.length){
            if(treeMap.containsKey(index)){
                StringBuffer stringBuffer = treeMap.get(index);
                stringBuffer.append(chars[i]+"");
            }else{
                StringBuffer stringBuffer = new StringBuffer(chars[i]+"");
                treeMap.put(index,stringBuffer);
            }
            i++;
            if(f == 0){
                index ++;
            }
            if(f == 1){
                index --;
            }
            if(i>0 && index==0){
                f = 0;
            }
            if(index == numRows -1){
                f = 1;
            }
        }
        StringBuffer result = new StringBuffer();
        for (Map.Entry<Integer, StringBuffer> entry : treeMap.entrySet()) {
            result.append(entry.getValue());
        }
        return result.toString();
    }

    @Test
    public void fun(){
        String s = "LEETCODEISHIRING";
        int numRows = 3;
        System.out.println(convert(s,numRows));
//        System.out.println(1%4);
    }
}
