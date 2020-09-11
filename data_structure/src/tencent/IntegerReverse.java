package tencent;

import org.junit.Test;

public class IntegerReverse {

    public int reverse(int x) {
        long n = 0;
        while(x !=0 ){
            n = n*10 + x%10;
            x = x/10;
        }
        return (int)n == n?(int)n:0;
    }

    public boolean isPalindrome(int x) {
        long n = 0;
        int temp = x;
        while(x !=0 ){
            n = n*10 + x%10;
            x = x/10;
        }
        return (int)n == temp;
    }

    @Test
    public void fun(){
        System.out.println(reverse(121));
        System.out.println(isPalindrome(121));
    }


}
