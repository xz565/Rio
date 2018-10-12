package company.gg;

import java.util.Stack;

public class MinStack_155 {

    // use a extra decreasing stack
    // 10, 10, 9, 9, 8,
    // put the previous min value before new min value
    //

    private int min = Integer.MAX_VALUE;
    private Stack<Integer> stack = new Stack<>();

    public MinStack_155() {

    }

    public void push(int x) {
        if (x <= min) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.pop() == min) min = stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }
}
