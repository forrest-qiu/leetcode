package preday;

import java.util.*;

public class No802 {

    public List<Integer> eventualSafeNodes(int[][] graph) {
        Map<Integer,List<Integer>> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            List<Integer> list = map.get(i);
            if(list == null){
                list = new ArrayList<>();
            }
            for (int j = 0; j < graph[i].length; j++) {
                list.add(graph[i][j]);
            }
            if(list.size()==0){
                ans.add(i);
            }
            map.put(i,list);
        }



        return ans;
    }
}
