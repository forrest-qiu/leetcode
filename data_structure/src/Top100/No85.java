package Top100;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 */
public class No85 {

    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        if(rows==0){
            return 0;
        }
        int columns = matrix[0].length;
        int[][] left = new int[rows][columns]; //记录i,j左边连续1的数量
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(matrix[i][j]=='1'){
                    left[i][j] = ( j== 0? 0 : left[i][j-1]+1 );
                }
            }
        }
        int ret = 0;
        for (int i = 0; i < columns; i++) {
            int[] up = new int[rows];
            int[] down = new int[rows];
            Deque<Integer> stack = new LinkedList<>();
            for (int j = 0; j < rows; j++) {
                while(!stack.isEmpty()&&left[stack.peek()][i]>=left[j][i]){
                    stack.pop();
                }
                up[j] = stack.isEmpty()?-1:stack.peek();
                stack.push(j);
            }
            stack.clear();
            for (int j = rows-1; j >= 0; j--) {
                while(!stack.isEmpty()&&left[stack.peek()][i]>=left[j][i]){
                    stack.pop();
                }
                down[j] = stack.isEmpty()?rows:stack.peek();
                stack.push(j);
            }
            for (int j = 0; j < rows ; j++) {
                int height = down[j]-up[j]-1;
                int area = height * left[j][i];
                ret = Math.max(area,ret);
            }
        }
        return ret;
    }


    @Test
    public void fun(){

    }
}
