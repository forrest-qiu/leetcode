package tencent;

import org.junit.Test;

public class MaxArea {
	
	/**
	 * 方法一
	 * @param height
	 * @return
	 */
	 public int maxArea(int[] height) {
	     int maxArea = 0;
	     for (int i = 0; i < height.length; i++) {
	    	 for(int j = i+1;j<height.length;j++) {
	    		 int temp = Math.min(height[i], height[j])*(j -i);
	    		 if(temp >= maxArea) {
	    			 maxArea = temp;
	    		 } 
	    	 }
		 }
		 return maxArea;
     }
	 
	 /**
	  * 方法二
	  * @param height
	  * @return
	  */
	 public int maxArea2(int[] height) {
		
		 return 0;
	 }
	
	 
	 @Test
	 public void fun() {
		 String x = "3";
		 System.out.println(x.hashCode());
		 
	 }
	
}
