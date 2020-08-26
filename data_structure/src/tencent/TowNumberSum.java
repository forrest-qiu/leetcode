package tencent;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

//两数之和
public class TowNumberSum {

    private int[] arr = new int[]{1,3,5,2,8,11};

    private int target = 10;

    @Test
    public void fun(){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < arr.length; i++ ){
            int complement = target - arr[i];
            if(map.containsKey(complement)){
                System.out.println(map.get(complement)+"\t====\t"+i);
            }
            map.put(arr[i],i);
        }
    }

}
