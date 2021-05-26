package Top100;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。
 *
 * 另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。
 *
 * 返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。如果问题中出现了给定的已知条件中没有出现的字符串，也需要用 -1.0 替代这个答案。
 *
 * 注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。
 *
 */
public class No399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int num = 0;//给每个字符编码
        Map<String,Integer> map = new HashMap<>();
        for (List<String> equation : equations) {
            for (String s : equation) {
                if(!map.containsKey(s)){
                   map.put(s,num++);
                }
            }
        }
        int n = num+1;
        double[][] graph = new double[n][n];//构造图
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String start = equation.get(0);
            String end = equation.get(1);
            int s = map.get(start);
            int e = map.get(end);
            graph[s][e] = values[i];
            graph[e][s] = 1/values[i];
        }
        //计算最短路径
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if(j==k||graph[j][k]!=0) continue;
                    if(graph[j][i]!=0&&graph[i][k]!=0){
                        graph[j][k] = graph[j][i]*graph[i][k];
                    }
                }
            }
        }
        //获取答案
        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> list = queries.get(i);
            String a = list.get(0);
            String b = list.get(1);
            if(map.containsKey(a)&&map.containsKey(b)){
                double c = graph[map.get(a)][map.get(b)];
                ans[i] = (c==0?-1.0d:c);
            }else{
                ans[i] = -1.0d;
            }
        }

        return ans;

    }


}
