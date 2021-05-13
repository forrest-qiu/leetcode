package Top100;

import org.junit.Test;

/**
 * 给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 */
public class No633 {

    public boolean judgeSquareSum(int c) {
        for (double i = Math.ceil(Math.sqrt(c)); i >=0; i--) {
            for (double j = Math.ceil(Math.sqrt(c - i*i)); j >=0; j--) {
                if(i * i + j * j == Double.valueOf(c)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean judgeSquareSum2(int c) {
        int a = 0;
        double b = Math.ceil(Math.sqrt(c));

        while (a <= b){
            double val = a * a + b * b;
            if(val == Double.valueOf(c)){
                return true;
            }else if(val < Double.valueOf(c)){
                a++;
            }else if(val > Double.valueOf(c)){
                b--;
            }
        }
        return false;
    }

    @Test
    public void test(){
        long start = System.currentTimeMillis();
        System.out.println(judgeSquareSum2(5));
        long end = System.currentTimeMillis();
        System.out.println((end-start)/1000d+"秒");
    }

}
