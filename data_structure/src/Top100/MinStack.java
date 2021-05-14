package Top100;

import java.util.Collections;
import java.util.LinkedList;

public class MinStack {
    private LinkedList<Integer> stack;
    private LinkedList<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();
        minStack.add(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        minStack.addFirst(Math.min(minStack.peek(),val));
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}