package Top100;

import org.junit.Test;

import java.util.*;

/**
 * 给你一个二维矩阵 matrix 和一个整数 k ，矩阵大小为 m x n 由非负整数组成。
 *
 * 矩阵中坐标 (a, b) 的 值 可由对所有满足 0 <= i <= a < m 且 0 <= j <= b < n 的元素 matrix[i][j]（下标从 0 开始计数）执行异或运算得到。
 *
 * 请你找出 matrix 的所有坐标中第 k 大的值（k 的值从 1 开始计数）。
 *
 */
public class No1738 {

    public int kthLargestValue(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] xx = new int[n][m];
        xx[0][0] = matrix[0][0];
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int temp = matrix[i][j];
                if(i>0){
                    temp =  temp^xx[i-1][j];
                }
                if(j>0){
                    temp =  temp^xx[i][j-1];
                }
                if(i>0&&j>0){
                    temp = temp^xx[i-1][j-1];
                }
                xx[i][j] = temp;
                ans.add(temp);
            }
        }
        Collections.sort(ans);
        if(k <= ans.size()){
            return ans.get(ans.size()-k);
        }else{
            return 0;
        }
    }

    @Test
    public void test(){
        int[][] matrix = {{5,2},{1,6}};
//        int[][] matrix ={{10,9,5},{2,0,4},{1,0,9},{3,4,8}};
        System.out.println(kthLargestValue(matrix,1));
        System.out.println(kthLargestValue(matrix,2));
        System.out.println(kthLargestValue(matrix,3));
        System.out.println(kthLargestValue(matrix,4));
    }
}
