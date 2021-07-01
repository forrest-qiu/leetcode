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
	    List<String> list = new ArrayList<>();
	    for (int i = a2.length - 1; i >= 0; i-- ) {
	    	int remainder = 0;
	    	StringBuffer sb  = new StringBuffer();
			for (int j = a1.length - 1 ; j >= 0; j--) {
				int x = (a2[i]-48) * (a1[j]-48);
				if(j==0){
					sb = new StringBuffer((x+remainder)+"").append(sb);
				}else{
					sb = new StringBuffer(((x%10)+remainder)%10+"").append(sb);
				}
				//获取余数
				remainder = x/10 + ((x%10)+remainder)/10;
			}
			list.add(sb.toString());
		}
	    StringBuffer ans = new StringBuffer();
	    StringBuffer sub = new StringBuffer();
		for (String s : list) {
			s = s.concat(sub.toString());
			ans = addStrNumber(s,ans.toString());
			sub.append("0");
		}
		int index = ans.length()-1;
		for (int i = 0; i < ans.length(); i++) {
			if(ans.charAt(i)!='0'){
				index = i;
				break;
			}
		}
		return ans.substring(index);
	}


	public StringBuffer addStrNumber(String num1,String num2){
		int i = num1.length() - 1, j = num2.length() - 1, add = 0;
		StringBuffer ans = new StringBuffer();
		while (i >= 0 || j >= 0 || add != 0) {
			int x = i >= 0 ? num1.charAt(i) - '0' : 0;
			int y = j >= 0 ? num2.charAt(j) - '0' : 0;
			int result = x + y + add;
			ans.append(result % 10);
			add = result / 10;
			i--;
			j--;
		}
		ans.reverse();
		return ans;
	}
	
	@Test
	public void fun() {
//		System.out.println(multiply("54", "2"));
		System.out.println(multiply("123", "456"));
		System.out.println(multiply("123456789", "987654321"));
		System.out.println(multiply("9133", "0"));
	}

}
