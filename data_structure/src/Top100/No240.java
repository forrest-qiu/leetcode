package Top100;

import org.junit.Test;

/**
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 *
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列
 *
 */
public class No240 {

    boolean ans = false;

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int m = 0;
        int n = matrix[0].length - 1;
        while (m < matrix.length && n >= 0) {
            if (matrix[m][n] == target) {
                return true;
            } else if (matrix[m][n] > target) {
                n--;
            } else {
                m++;
            }
        }
        return false;
    }

    public void search(int[][] matrix,int i,int j,int target){
        if(i>=matrix.length||j>=matrix[0].length||ans||matrix[i][j]>target){
            return;
        }
        if(matrix[i][j]==target){
            ans = true;
            return;
        }
        if(matrix[i+1][j]>target&&matrix[i][j+1]<=target){
            search(matrix,i,j+1,target);
        }
        if(matrix[i+1][j]<=target&&matrix[i][j+1]>target){
            search(matrix,i+1,j,target);
        }
        if(matrix[i+1][j]<=target&&matrix[i][j+1]<=target){
            search(matrix,i,j+1,target);
            search(matrix,i+1,j,target);
        }
    }

    @Test
    public void test(){
//       int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
//       int target = 28;
//       int[][] matrix = {{-1,3}};
//       int target = 1;
//       int[][] matrix = {{1,3,5}};
        int[][] matrix = {
                          {1,2,3,4,5},
                          {6,7,8,9,10},
                          {11,12,13,14,15},
                          {16,17,18,19,20},
                          {21,22,23,24,25}
                        };
        System.out.println(searchMatrix(matrix,15));

    }
}
