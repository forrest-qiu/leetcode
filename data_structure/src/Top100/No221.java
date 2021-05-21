package Top100;

/**
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 */
public class No221 {

    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        if(n<1){
            return 0;
        }
        int m = matrix[0].length;
        int[][] dp = new int[n+1][m+1];
        int max = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if(matrix[i][j]=='1'){
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                    max = Math.max(max,dp[i][j]);
                }
            }
        }
        return max*max;
    }


}
