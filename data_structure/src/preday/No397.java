package preday;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class No397 {


    public int integerReplacement(int n) {
        return (int) dfs(n);
    }

    public long dfs(long n){
       if(n==1){
           return 0;
       }
       if(n%2==0){
           return 1+dfs(n/2);
       }else{
           return Math.min(dfs(n+1),dfs(n-1))+1;
       }
    }

    @Test
    public void test(){
//        System.out.println(integerReplacement(8));
//        System.out.println(integerReplacement(7));
//        System.out.println(integerReplacement(2147483647));

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(2,10,300, TimeUnit.SECONDS,new ArrayBlockingQueue<>(10));
    }


}
