package Top100;

import java.util.ArrayList;
import java.util.List;

public class No54 {
    /**
     * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int row = matrix.length;  //行
        int column = matrix[0].length;  //列
        int left = 0;
        int right = column -1;
        int bottom = row -1;
        int top = 0;
        while(left<=right && top<=bottom){
            for (int i = left; i <= right ; i++) {
                result.add(matrix[top][i]);
            }
            for (int i = top+1; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            if(left<right&&top<bottom){
                for (int i = right-1; i >left ; i--) {
                    result.add(matrix[bottom][i]);
                }
                for (int i = bottom-1; i > top ; i--) {
                    result.add(matrix[i][left]);
                }
            }
            left++;
            right--;
            bottom--;
            top++;
        }
        return result;
    }


}
