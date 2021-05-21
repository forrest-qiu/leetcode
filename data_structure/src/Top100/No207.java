package Top100;

import org.junit.Test;

import java.util.*;

/**
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 *
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 *
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 *
 */
public class No207 {
    /**
     * 1、判断图是否有环，利用图节点的出度来计算
     * 2、构造邻接表
     * 3、利用入度矩阵存储每个节点的入度
     * 4、将入度为0的节点一次入队
     * 5、判断是否全部入队
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graphic = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graphic[i] = new ArrayList<>();
        }
        for (int[] prerequisite : prerequisites) {
            graphic[prerequisite[1]].add(prerequisite[0]);
        }
        //创建入度
        int[] inDegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            List<Integer> pre = graphic[i];
            for (Integer num : pre) {
                inDegree[num] += 1;
            }
        }
        //入度为0的节点入队
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if(inDegree[i] == 0){
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            int temp  = queue.poll();
            numCourses--;
            for (int num : graphic[temp]) {
                inDegree[num] -= 1;
                if(inDegree[num]==0){
                    queue.offer(num);
                }
            }
        }
        return numCourses == 0;
    }


    @Test
    public void test(){
        int numCourses = 2;
        int[][] prerequisites = {{1,0}};
        System.out.println(canFinish(2,prerequisites));
    }
}
