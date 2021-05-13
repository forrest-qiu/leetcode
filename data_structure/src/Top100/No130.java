package Top100;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 *  
 */
public class No130 {
    int n, m;

    public void solve(char[][] board) {
        n = board.length;
        if (n == 0) {
            return;
        }
        m = board[0].length;
        for (int i = 0; i < n; i++) {
            dfs(board, i, 0);
            dfs(board, i, m - 1);
        }
        for (int i = 1; i < m - 1; i++) {
            dfs(board, 0, i);
            dfs(board, n - 1, i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void dfs(char[][] board, int x, int y) {
        if (x < 0 || x >= n || y < 0 || y >= m || board[x][y] != 'O') {
            return;
        }
        board[x][y] = 'A';
        dfs(board, x + 1, y);
        dfs(board, x - 1, y);
        dfs(board, x, y + 1);
        dfs(board, x, y - 1);
    }


    public void fun(List<int[]> list,char[][] board,int i,int j,int rows,int cols,boolean w){
        if(i>rows-1||j>cols-1){
            return;
        }
        int origin_i = i,origin_j = j;
        for (int k = j; k < cols ; k++) {
            just(list,board,i,j,w);
            j=k;
        }
        for (int k = i+1; k < rows; k++) {
            just(list,board,i,j,w);
            i=k;
        }
        for (int k = j-1; k >= origin_j ; k--) {
            just(list,board,i,j,w);
            j=k;
        }
        for (int k = i-1; k >= origin_i ; k--) {
            just(list,board,i,j,w);
            i=k;
        }
        fun(list,board,i+1,j+1,rows-1,cols-1,false);
    }

    public void just(List<int[]> list,char[][] board,int i,int j,boolean w){
        if (board[i][j] == 'O') {
            if(w){
                list.add(new int[]{i, j});
            }else if(isContain(list,i,j)){
                list.add(new int[]{i, j});
            }else{
                board[i][j] = 'X';
            }
        }
    }

    public boolean isAccess(char[][] board,int i,int j){
        int rows = board.length;
        int cols = board[0].length;
        if(i==0||i==rows-1||j==0||j==cols-1){
            return true;
        }
        int count = 0;
        for (int k = i+1; k < rows; k++) {
            if(board[k][j]=='O'){
                count++;
            }
        }
        if(count==rows-i){
            return true;
        }
        count=0;
        for (int k = i-1; k >=0 ; k--) {
            if(board[k][j]=='O'){
                count++;
            }
        }
        if(count==i){
            return true;
        }
        count = 0;
        for (int k = j+1; k < cols; k++) {
            if(board[k][j]=='O'){
                count++;
            }
        }
        if(count == cols-j){
            return true;
        }
        count = 0;
        for (int k = j-1; k >=0 ; k--) {
            if(board[k][j]=='O'){
                count++;
            }
        }
        if(count == j){
            return true;
        }
        return false;
    }


    public boolean isContain(List<int[]> list, int i, int j) {
        for (int[] ints : list) {
            if (i == ints[0] && Math.abs(j - ints[1]) <= 1) {
                return true;
            } else if (j == ints[1] && Math.abs(i - ints[0]) <= 1) {
                return true;
            }
        }
        return false;
    }

    @Test
    public void test() {
//        char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        char[][] board = {
                {'O', 'X', 'X', 'O', 'X'},
                {'X', 'O', 'O', 'X', 'O'},
                {'X', 'O', 'X', 'O', 'X'},
                {'O', 'X', 'O', 'O', 'O'},
                {'X', 'X', 'O', 'X', 'O'}
        };
        solve(board);
        System.out.println(board);

    }
}
