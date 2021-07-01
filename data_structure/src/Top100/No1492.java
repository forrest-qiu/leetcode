package Top100;

import org.junit.Test;

public class No1492 {

    public int kthFactor(int n, int k) {
        for (int i = 1; i <= n; i++) {
            if(n%i==0){
                k--;
                if(k==0){
                    return i;
                }
            }
        }
        return -1;
    }

    @Test
    public void test(){
        System.out.println(kthFactor(7,2));
        System.out.println(kthFactor(4,4));
        System.out.println(kthFactor(1,1));
        System.out.println(kthFactor(1000,3));
    }
}
