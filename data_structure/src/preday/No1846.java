package preday;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class No1846 {

    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        if(n==1){
            return 1;
        }
        Arrays.sort(arr);
        arr[0] = 1;
        for (int i = 1; i < n; i++) {
            if(arr[i]>arr[i-1]+1){
                arr[i] = arr[i-1]+1;
            }
        }
        return arr[n -1];
    }


    @Test
    public void test(){
//        int[] arr = {2,2,1,2,1};
//        int[] arr = {100,1,1000};
//        int[] arr = {1,2,3,4,5};
//        int[] arr = {73,98,9};
//        System.out.println(maximumElementAfterDecrementingAndRearranging(arr));

//        List<Integer> list1 = new ArrayList<>();
        List<Integer> list1 = new LinkedList<>();
        long start1 = System.currentTimeMillis();
        for (int i = 0; i < 50000000; i++) {
            list1.add(i);
        }
        long end1 = System.currentTimeMillis();
        System.out.println(end1-start1);

    }
}
