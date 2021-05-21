package Top100;

import org.junit.Test;

/**
 * 给你 二维 平面上两个 由直线构成的 矩形，请你计算并返回两个矩形覆盖的总面积。
 *
 * 每个矩形由其 左下 顶点和 右上 顶点坐标表示：
 *
 * 第一个矩形由其左下顶点 (ax1, ay1) 和右上顶点 (ax2, ay2) 定义。
 * 第二个矩形由其左下顶点 (bx1, by1) 和右上顶点 (bx2, by2) 定义。
 *
 */
public class No223 {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int area1 = (ax2-ax1)*(ay2-ay1);
        int area2 = (bx2-bx1)*(by2-by1);
        int x = getOver(new int[]{ax1,ax2},new int[]{bx1,bx2})*getOver(new int[]{ay1,ay2},new int[]{by1,by2});
        return area1+area2-x;
    }

    public int getOver(int[] x,int[] y){
        int x1 = x[0],x2 = x[1],y1 = y[0],y2 = y[1];
        if(x1<y1&&y1<=x2&&x2<=y2){
            return x2 - y1;
        }else if(y1<=x1&&x2<=y2){
            return x2 - x1;
        }else if(y1<x1&&x1<=y2&&y2<=x2){
            return y2 - x1;
        }else if(y1>=x1&&y2<=x2){
            return y2 - y1;
        }else{
            return 0;
        }
    }

    @Test
    public void test(){
//        int ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 2;
//        int ax1 = -2, ay1 = -2, ax2 = 2, ay2 = 2, bx1 = -2, by1 = -2, bx2 = 2, by2 = 2;
        int ax1 = 0,ay1 = 0,ax2 = 0,ay2 = 0,bx1 = -1,by1 = -1,bx2 = 1,by2 = 1;
        System.out.println(computeArea(ax1,ay1,ax2,ay2,bx1,by1,bx2,by2));
    }
}
