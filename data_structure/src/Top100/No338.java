package Top100;

/**
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 */
public class No338 {
    //如果i是偶数 f[i] = f[i/2]
    //如果i是奇数 f[i] = f[i-1] + 1
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        for (int i = 0; i <= n; i++) {
            if(i%2==0){
                ans[i] = ans[i/2];
            }else{
                ans[i] = ans[i-1]+1;
            }
        }
        return ans;
    }
}
