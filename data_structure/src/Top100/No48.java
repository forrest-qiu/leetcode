package Top100;

public class No48 {

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; ++i) {
            for (int j = 0; j < (n + 1) / 2; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }


    public void rotation(int[][] nums,int c){
        int length = nums[0].length - 2<<(c-1);
        for (int i = 0; i < 4; i++) {
            int[] temp = new int[length];
            for (int j = 0; j < length; j++) {
                temp[j] = nums[j][length-c];
                nums[j][length-c] = nums[c+1][j];
            }
        }
    }
}
