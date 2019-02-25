package tencent;

import java.util.Stack;

import org.junit.Test;

public class Bracket {
	
	public boolean isValid(String s) {
		if(s.isEmpty()) {
			return false;
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
}
