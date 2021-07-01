package offer;

import org.junit.Test;

import java.util.*;

public class No815 {

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source==target){
            return 0;
        }
        Map<Integer, List<Integer>> siteBusMap = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                int site = routes[i][j];
                List<Integer> bus = siteBusMap.get(site);
                if(bus==null){
                    bus = new ArrayList<>();
                }
                bus.add(i);
                siteBusMap.put(site,bus);
            }
        }
        if(!siteBusMap.containsKey(source)&&!siteBusMap.containsKey(target)){
            return -1;
        }
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visit = new HashSet();
        for (Integer line : siteBusMap.get(source)) {
            queue.offer(line);
            visit.add(line);
        }
        int step = 1;
        while(!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                for (Integer line : routes[poll]) {
                    if(visit.contains(line)){
                        continue;
                    }
                    for (int site : siteBusMap.get(line)) {
                        if(site == target){
                            return step;
                        }
                        queue.offer(site);
                    }
                    visit.add(line);
                }
            }
            step++;
        }
        return -1;
    }

    @Test
    public void test(){
        int[][] routes = {{1,2,7},{3,6,7}};
        int source = 1,target = 6;
        System.out.println(numBusesToDestination(routes,source,target));
    }
}
