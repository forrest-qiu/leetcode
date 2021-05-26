package Top100;

import org.junit.Test;

import java.util.Arrays;

/**
 * 你在和朋友一起玩 猜数字（Bulls and Cows）游戏，该游戏规则如下：
 * <p>
 * 你写出一个秘密数字，并请朋友猜这个数字是多少。
 * 朋友每猜测一次，你就会给他一个提示，告诉他的猜测数字中有多少位属于数字和确切位置都猜对了（称为“Bulls”, 公牛），有多少位属于数字猜对了但是位置不对（称为“Cows”, 奶牛）。
 * 朋友根据提示继续猜，直到猜出秘密数字。
 * 请写出一个根据秘密数字和朋友的猜测数返回提示的函数，返回字符串的格式为 xAyB ，x 和 y 都是数字，A 表示公牛，用 B 表示奶牛。
 * <p>
 * xA 表示有 x 位数字出现在秘密数字中，且位置都与秘密数字一致。
 * yB 表示有 y 位数字出现在秘密数字中，但位置与秘密数字不一致。
 * 请注意秘密数字和朋友的猜测数都可能含有重复数字，每位数字只能统计一次。
 */
public class No299 {
    public String getHint(String secret, String guess) {
        int a = 0, b = 0;
        int len1 = secret.length();
        int len2 = guess.length();
        boolean[] s = new boolean[len1];
        boolean[] g = new boolean[len2];
        Arrays.fill(s, false);
        Arrays.fill(g, false);
        for (int i = 0; i < len1; i++) {
            if(secret.charAt(i)==guess.charAt(i)&&!g[i]){
                a++;
                g[i] = true;
                s[i] = true;
            }
        }
        for (int i = 0; i < len1; i++) {
            if(!s[i]){
                for (int j = 0; j < len2; j++) {
                    if(!g[j]){
                        if(secret.charAt(i)==guess.charAt(j)){
                            b++;
                            s[i] = true;
                            g[j] = true;
                            break;
                        }
                    }
                }
            }
        }
        return a +"A" + b + "B";
    }


    @Test
    public void test() {
        System.out.println(getHint("1807", "7810"));
        System.out.println(getHint("1123","0111"));
        System.out.println(getHint("1122","1222"));
    }
}
