package offer;

import org.junit.Test;

import java.util.List;
import java.util.Set;

/**
 * 给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上。
 */
public class No149 {

    public int maxPoints(int[][] points) {
        int n = points.length;
        if(n<=2){
            return n;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n ; j++) {
                int[] a = points[i];
                int[] b = points[j];
                //a(x1,y1)  b(x2,y2)
                int x1 = a[0],y1 = a[1],x2 = b[0],y2 = b[1],temp = 2;;
                if(x2 == x1){
                    for (int k = 0; k < n; k++) {
                        if(k!=j&&k!=i){
                            int[] d = points[k];
                            if(d[0]==x1){
                                temp++;
                            }
                        }
                    }
                    ans = Math.max(ans,temp);
                    if(ans == points.length){
                        return ans;
                    }
                    continue;
                }
                double t = (y2 - y1)/(x2 - x1 + 0.00d);
                double c = (x2 * y1 - x1* y2)/(x2 - x1 + 0.00d);
                if(t == 0 && c == 0){
                    continue;
                }
                for (int k = 0; k < n; k++) {
                    if(k!=j&&k!=i){
                        int[] d = points[k];
                        if(d[1] == (t*d[0] + c)){
                            temp++;
                        }
                    }
                }
                ans = Math.max(ans,temp);
                if(ans == points.length){
                    return ans;
                }
            }
        }
        return ans;
    }

    @Test
    public void test(){
//        int[][] points = {{1,1},{2,2},{3,3}};
//        int[][] points = {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
        int[][] points = {{-6,-1},{3,1},{12,3}};
        System.out.println(maxPoints(points));
    }

    public static void main(String[] args) {
        System.out.println(Test3.x);
    }
}


class Test3{
    static final String x = "1";
}