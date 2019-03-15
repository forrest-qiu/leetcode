package tencent;

import java.util.Iterator;
import java.util.TreeSet;

import org.junit.Test;

public class DuplicateArray {
		
	
	 public int removeDuplicates(int[] nums) {
		TreeSet<Integer> set = new TreeSet<>();
	    for (int i = 0; i < nums.length; i++) {
	    	set.add(nums[i]);
		}
	    int j = 0;
	    Iterator<Integer> iterator = set.iterator();
	    while(iterator.hasNext()) {
	    	nums[j] = iterator.next();
	    	j++;
	    }
		return set.size();
     }
	 
	 @Test
	 public void fun() {
		 int[] nums = {0,0,1,1,1,2,2,3,3,4};
		 System.out.println(removeDuplicates(nums));
	 }
	
}
