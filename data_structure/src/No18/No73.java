package No18;

import org.junit.Test;

import java.util.*;

/**
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 * <p>
 * 进阶：
 * <p>
 * 一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个仅使用常量空间的解决方案吗？
 */
public class No73 {

    /**
     * 方法一：
     * 存储值为0的行号和列号   空间复杂度O(m+n)  时间复杂度O(mn)
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        List<Integer> rows = new ArrayList<>();
        List<Integer> columns = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    columns.add(j);
                }
            }
        }
        for (Integer zero_column : columns) {
            for (int i = 0; i < row; i++) {
                matrix[i][zero_column] = 0;
            }
        }

        for (Integer zero_row : rows) {
            for (int i = 0; i < column; i++) {
                matrix[zero_row][i] = 0;
            }
        }
    }

    /**
     * 方法二：
     * 维护指针（i,j）,由外层往里层处理
     * @param matrix
     */
    public void setZeroes2(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        int i = 0,j = 0;




    }


    @Test
    public void fun(){
        int[][] x = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(x);
    }

}
