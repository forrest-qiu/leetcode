package No18;

import org.junit.Test;

import java.util.TreeSet;

/**
 * 给你一个 m x n 的矩阵 matrix 和一个整数 k ，找出并返回矩阵内部矩形区域的不超过 k 的最大数值和。
 *
 * 题目数据保证总会存在一个数值和不超过 k 的矩形区域。
 *
 */
public class No363 {
    int ans = Integer.MIN_VALUE;
    /**
     * 使用动态规划算法
     * @param matrix
     * @param k
     * @return
     */
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dfs(j,1,i,1,rows,cols,matrix,k);
            }
        }
        return ans;
    }

    public void dfs(int left,int width,int top,int height,int rows,int cols,int[][] matrix, int k){
        if(left+width>cols||top+height>rows){
            return;
        }
        int result = 0;
        //计算矩形值
        for (int i = top; i < top+height ; i++) {
            for (int j = left; j < left+width; j++) {
                result += matrix[i][j];
            }
        }
        if(result<=k){
            ans = Math.max(result,ans);
        }
        dfs(left,width+1,top,height,rows,cols,matrix,k);
        dfs(left,width,top,height+1,rows,cols,matrix,k);
    }


    public int maxSumSubmatrix2(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if(i-1>0){
                    matrix[i][j] += matrix[i-1][j];
                }
            }
        }
        for (int x = 0; x < rows ; x++) {
            for (int y = 0; y < cols; y++) {
                for (int x1 = x; x1 < rows; x1++) {
                    for (int y1 = y; y1 < cols; y1++) {
                        int ret = getSumRange(matrix,x,y,x1,y1);
                        if(ret<=k){
                            ans = Math.max(ans,ret);
                        }
                    }
                }
            }
        }

        return ans;
    }

    int getSumRange(int[][] matrix,int x1,int y1,int x2,int y2){
        int up = 0;
        int down = 0;
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2 ; j++) {
                if(i == x1 && x1-1>=0){
                    up += matrix[i-1][j];
                }
                if(i == x2){
                    down += matrix[i][j];
                }
            }
        }
        return down-up;
    }


    public int maxSumSubmatrix3(int[][] matrix, int k) {
        int ans = Integer.MIN_VALUE;
        int m = matrix.length, n = matrix[0].length;
        for (int i = 0; i < m; ++i) { // 枚举上边界
            int[] sum = new int[n];
            for (int j = i; j < m; ++j) { // 枚举下边界
                for (int c = 0; c < n; ++c) {
                    sum[c] += matrix[j][c]; // 更新每列的元素和
                }
                TreeSet<Integer> sumSet = new TreeSet<Integer>();
                sumSet.add(0);
                int s = 0;
                for (int v : sum) {
                    s += v;
                    Integer ceil = sumSet.ceiling(s - k);
                    if (ceil != null) {
                        ans = Math.max(ans, s - ceil);
                    }
                    sumSet.add(s);
                }
            }
        }
        return ans;
    }

    @Test
    public void fun(){
        int[][] matrix = {{1,0,1},{0,-2,3}};
        int k = 2;
        System.out.println(maxSumSubmatrix2(matrix,2));
    }
}
