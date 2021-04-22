package No18;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
 *
 * 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。即使有多个不同答案，你也只需要返回其中一种。
 *
 * 格雷编码序列必须以 0 开头。
 *
 */
public class No89 {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        fun(0,result,n);
        return result;
    }

    public List<Integer> fun(int n,List<Integer> list,int total){
        if(n==total){
            return list;
        }
        List<Integer> temp = new ArrayList<>();
        int i1 = 1 << n;
        for (int i = list.size() -1; i >= 0 ; i--) {
            temp.add(list.get(i) + i1);
        }
        list.addAll(temp);
        fun(n+1,list,total);
        return list;
    }

    @Test
    public void test(){
        System.out.println(grayCode(2));
    }
}
