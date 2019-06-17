package tencent;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * 	两数相乘
 * @author LX
 *
 */
public class StrMultiply {

	public String multiply(String num1, String num2) {
		char[] a1 = num1.toCharArray();
		char[] a2 = num2.toCharArray();
	    StringBuffer sb = new StringBuffer();
	    List<Integer> list = new ArrayList<>();
	    int k = 1;
	    for (int i = a2.length - 1; i >= 0; i-- ) {
			for (int j = a1.length - 1 ; j >= 0; j--) {
				int x = (a2[i]-48) * (a1[j]-48);
				
			}
		}
	    
	    
		return sb.toString();
	}
	
	@Test
	public void fun() {
//		System.out.println(multiply("22", "11"));
		System.out.println('9'-48);
	}

}
