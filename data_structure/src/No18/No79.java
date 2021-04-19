package No18;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 */
public class No79 {

    boolean result = false;
    int[][] direction = {{1,0},{-1,0},{0,1},{0,-1}};

    public boolean exist(char[][] board, String word) {
        List<int[]> first = new ArrayList<>();
        int rows = board.length;
        int columns = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(board[i][j]==word.charAt(0)){
                    first.add(new int[]{i,j});
                }
            }
        }
        for (int i = 0; i < first.size(); i++) {
            ArrayList<int[]> list = new ArrayList<>();
            list.add(first.get(i));
            dfs(board,rows,columns,first.get(i)[0],first.get(i)[1],word,1,list);
        }
        return result;
    }

    //动态规划去匹配下一个,row,col当前字符坐标，match下一个要匹配字符的索引
    public void dfs(char[][] board,int rows,int columns,int row,int col,String word,int match,List<int[]> path){
        if(match == word.length()){
            result = true;
            return;
        }
        for (int i = 0; i < direction.length; i++) {
            int next_row = row + direction[i][0];
            int next_col = col + direction[i][1];
            if(next_row<rows && next_row>=0 && next_col<columns && next_col>=0){
                if(board[next_row][next_col]==word.charAt(match)&&!containArray(path,new int[]{next_row,next_col})){
                    path.add(new int[]{next_row,next_col});
                    dfs(board,rows,columns,next_row,next_col,word,match+1,path);
                    path.remove(path.size()-1);
                }
            }
        }
    }

    public boolean containArray(List<int[]> list,int[] x){
        for (int[] ints : list) {
            if(ints[0]==x[0]&&ints[1]==x[1]){
                return true;
            }
        }
        return false;
    }
    @Test
    public void fun(){
//        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//        String word = "ABCCED";
//        char[][] board = {
//                          {'A','B','C','E'},
//                          {'S','F','C','S'},
//                          {'A','D','E','E'}
//                        };
//        String word = "SEE";
        char[][] board = {
                            {'A','B','C','E'},
                            {'S','F','C','S'},
                            {'A','D','E','E'}
                        };
        String word = "ABCB";
        System.out.println(exist(board,word));
    }

}
