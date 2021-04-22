package Top100;

import org.junit.Test;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 *
 * 问总共有多少条不同的路径？
 *
 */
public class No62 {
    int count = 1;
    public int uniquePaths(int m, int n) {
        add(m-1,n-1,0,0);
        return count;
    }

    public void add(int m,int n,int x,int y){
        if(x == m && y == n){
            return;
        }
        if(x < m && y < n){
            count++;
        }
        if(x < m){
            add(m,n,x+1,y);
        }
        if(y < n){
            add(m,n,x,y+1);
        }
    }


    public int uniquePaths2(int m, int n) {
        int[][] f = new int[m][n];
        for (int i = 0; i < m; ++i) {
            f[i][0] = 1;
        }
        for (int j = 0; j < n; ++j) {
            f[0][j] = 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m - 1][n - 1];
    }

    @Test
    public void fun(){
        System.out.println(uniquePaths2(3,2));
    }


    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n =  grid[0].length;
        int[][] f = new int[m][n];
        f[0][0] = grid[0][0];
        for (int i = 1; i < m; ++i) {
            f[i][0] = f[i-1][0] + grid[i][0];
        }
        for (int j = 1; j < n; ++j) {
            f[0][j] = f[0][j-1] + grid[0][j];
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                f[i][j] = Math.min(f[i - 1][j],f[i][j - 1])+grid[i][j];
            }
        }
        return f[m - 1][n - 1];
    }
}
