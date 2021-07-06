package preday;

import org.junit.Test;

import java.util.*;

/**
 * 给定一个化学式formula（作为字符串），返回每种原子的数量。
 *
 * 原子总是以一个大写字母开始，接着跟随0个或任意个小写字母，表示原子的名字。
 *
 * 如果数量大于 1，原子后会跟着数字表示原子的数量。如果数量等于 1 则不会跟数字。例如，H2O 和 H2O2 是可行的，但 H1O2 这个表达是不可行的。
 *
 * 两个化学式连在一起是新的化学式。例如 H2O2He3Mg4 也是化学式。
 *
 * 一个括号中的化学式和数字（可选择性添加）也是化学式。例如 (H2O2) 和 (H2O2)3 是化学式。
 *
 * 给定一个化学式，输出所有原子的数量。格式为：第一个（按字典序）原子的名子，跟着它的数量（如果数量大于 1），然后是第二个原子的名字（按字典序），跟着它的数量（如果数量大于 1），以此类推
 *
 */
public class No726 {

    public String countOfAtoms(String formula) {
        Map<String,Integer> map = new TreeMap<>();
        int left = formula.lastIndexOf("(");
        int right = formula.indexOf(")",left+1);
        while ( left>-1 && right>-1 ){
            String temp = formula.substring(left+1,right);
            int num = getMultiNumber(formula,right);
            int x = getNumber(formula,right);
            loadData(temp,map,num);
            formula = formula.substring(0,left) + formula.substring(right+(x==1?1:String.valueOf(x).length()+1));
            left = formula.lastIndexOf("(");
            right = formula.indexOf(")",left+1);
        }
        loadData(formula,map,1);
        StringBuffer ans = new StringBuffer();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            ans.append(entry.getKey()).append(entry.getValue()==1?"":entry.getValue());
        }
        return ans.toString();
    }


    public int getMultiNumber(String str,int index){
        int ans = 1;
        while (index < str.length()){
            ans =  ans * getNumber(str,index);
            index = str.indexOf(")",index+1);
            if(index==-1){
                break;
            }
        }
        return ans;
    }

    public int getNumber(String str,int index){
        StringBuffer sb = new StringBuffer();
        while(++index<str.length()){
            char x = str.charAt(index);
            if(x <= '9' && x >= '0'){
                sb.append(x);
            }else{
                break;
            }
        }
        return sb.length()==0?1:Integer.parseInt(sb.toString());
    }

    public void loadData(String str,Map<String,Integer> map,int num){
        int i = 0;
        while (i < str.length()) {
            StringBuffer temp = new StringBuffer(String.valueOf(str.charAt(i)));
            while ((i+1)<str.length() && str.charAt(i+1) >= 'a' && str.charAt(i+1) <= 'z'){
                temp.append(str.charAt(++i));
            }
            int number = getNumber(str,i);
            map.put(temp.toString(),map.getOrDefault(temp.toString(),0)+num*number);
            i = (number==1?i+1:i+String.valueOf(number).length()+1);
        }
    }


    @Test
    public void test(){
//        System.out.println(countOfAtoms("H2O"));
//        System.out.println(countOfAtoms("Mg(OH)2"));
//        System.out.println(countOfAtoms("K4(ON(SO3)2)2"));
//        System.out.println(countOfAtoms("(NB3)33"));
//        System.out.println(countOfAtoms("((HHe28Be26He)9)34"));
        System.out.println(countOfAtoms("((N42)24(OB40Li30CHe3O48LiNN26)33(C12Li48N30H13HBe31)21(BHN30Li26BCBe47N40)15(H5)16)14"));
    }
}
