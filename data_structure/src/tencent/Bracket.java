package tencent;

import java.util.Stack;

import org.junit.Test;

public class Bracket {
	
	public boolean isValid(String s) {
		if(s.isEmpty()) {
			return true;
		}
		Stack<Character> stack = new Stack<>();
		for(char c : s.toCharArray()) {
			if(c == '(') {
				stack.push(')');
			}else if( c == '{') {
				stack.push('}');
			}else if(c == '[') {
				stack.push(']');
			}else if(stack.isEmpty() || stack.pop() != c) {
				return false;
			}
		}
		return stack.isEmpty();
    } 
	
	@Test
	public void fun() {
		String s = "([]{})";
		System.out.println(isValid(s));
	}
	
	@Test
	public void fun2() {
		String a = "yy";
		int x = 2;
		System.out.println(addStr(a));
		System.out.println(a);
		System.out.println(addInt(x));
		System.out.println(x);
	}
	
	public String addStr(String a) {
		a = a +"xx";
		return a;
	}
	
	public int addInt(int a) {
		a = a+3;
		return a;
	}
}
