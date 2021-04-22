package No18;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。你可以按任何顺序返回答案。
 *
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 *
 */
public class No93 {

    List<String> result = new ArrayList<>();
    int seq_count = 4;
    int[] segments = new int[seq_count];

    public List<String> restoreIpAddresses(String s) {
        dfs(s,0,0);
        return result;
    }

    public void dfs(String s,int seq,int index){
        if(seq == seq_count){
            if(index == s.length()){
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < segments.length; i++) {
                    sb.append(segments[i]);
                    if(i != seq_count-1){
                        sb.append('.');
                    }
                }
                result.add(sb.toString());
            }
            return;
        }
        if(index == s.length()){
            return;
        }
        //开始减枝
        if(s.charAt(index) == '0'){
            segments[seq] = 0;
            dfs(s,seq+1,index+1);
        }

        //一般情况处理
        int addr = 0;
        for (int i = index; i < s.length(); i++) {
            addr = addr*10 + (s.charAt(i)-'0');
            if(addr>0&&addr<=255){
                segments[seq] = addr;
                dfs(s,seq+1,i+1);
            }else{
                break;
            }
        }
    }

    @Test
    public void fun(){

    }
}
