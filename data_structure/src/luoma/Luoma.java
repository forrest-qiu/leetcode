package luoma;

import org.junit.Test;

import java.util.HashMap;

/**
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，
 * 所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 */
public class Luoma {

    public int fun(String s){
        HashMap<String,Integer> map = new HashMap<>();
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);
        map.put("IV",4);
        map.put("IX",9);
        map.put("XL",40);
        map.put("XC",90);
        map.put("CD",400);
        map.put("CM",900);

        int length = s.length();
        int result = 0;
        int i = 0;
        while(i<length){
            if(i<length-1){
                String s1 = s.charAt(i) + String.valueOf(s.charAt(i + 1));
                if(map.containsKey(s1)){
                    result += map.get(s1);
                    i+=2;
                }else{
                    result += map.get(String.valueOf(s.charAt(i)));
                    i++;
                }
            }else{
                result += map.get(String.valueOf(s.charAt(i)));
                i++;
            }
        }
        return result;
    }

    public int fun2(String s){
        int result = getInt(s.charAt(0));
        int pre = result;
        for (int i = 1; i < s.length(); i++) {
            int anInt = getInt(s.charAt(i));
            if(pre < anInt){
                result = result - pre + (anInt - pre);
            }else{
                result += anInt;
            }
            pre = anInt;
        }
        return result;
    }

    /**
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * @param x
     * @return
     */
    public int getInt(char x){
        switch (x){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    /**
     * 整数转罗马字符串
     * @param num
     * @return
     */
    public String intToRoma(int num){




        return null;
    }



    @Test
    public void test(){
        String x = "III";
        System.out.println(fun(x));
        System.out.println(fun2(x));
        String x2 = "LVIII";
        System.out.println(fun(x2));
        System.out.println(fun2(x2));
        String x3 = "IV";
        System.out.println(fun(x3));
        System.out.println(fun2(x3));
        String x4 = "MCMXCIV";
        System.out.println(fun(x4));
        System.out.println(fun2(x4));

        System.out.println("中国".toLowerCase());
    }

}
