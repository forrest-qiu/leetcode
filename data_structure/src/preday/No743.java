package preday;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No743 {

    public int networkDelayTime(int[][] times, int n, int k) {
        int ans = 0;
        Map<Integer,List<int[]>> map = new HashMap<>();
        Map<Integer,Integer> visited = new HashMap<>();
        for (int i = 0; i < times.length; i++) {
            int[] item = times[i];
            visited.put(item[0],0);
            visited.put(item[1],0);
            List<int[]> ints = map.get(item[0]);
            if(ints==null){
                ints = new ArrayList<>();
            }
            int[] temp = new int[2];
            temp[0] = item[1];
            temp[1] = item[2];
            ints.add(temp);
            map.put(item[0],ints);
        }
        //没有从目标节点出发的路径
        if(!map.containsKey(k)){
            return -1;
        }
        List<int[]> routes = map.get(k);
        //如果起点孤立，或是有孤立点
        if(routes.size()==0||visited.size()<n){
            return -1;
        }
        for (int[] route : routes) {
            visited.put(route[0],1);
        }



        return ans;
    }
}
