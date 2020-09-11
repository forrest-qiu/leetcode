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

    @Test
    public void fun2(){
        byte a = 2;
        byte b = 2;
        System.out.println(a&b);
    }

    /**
     * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     * @return
     */
    public int findOne(int[] nums){


        return 0;
    }

}
