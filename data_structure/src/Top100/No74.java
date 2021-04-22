package Top100;

/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 *
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *
 */
public class No74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int column = matrix[0].length;
        if(matrix[0][0]>target||matrix[row-1][column-1]<target){
            return false;
        }
        for (int i = 0; i < row -1; i++) {
            if(matrix[i][0]<=target && matrix[i+1][0]>target){
                for (int j = 0; j < column; j++) {
                    if(matrix[i][j] == target){
                        return true;
                    }
                }
            }
        }
        if(matrix[row-1][0]<=target){
            for (int j = 0; j < column; j++) {
                if(matrix[row-1][j] == target){
                    return true;
                }
            }
        }
        return false;
    }
}
