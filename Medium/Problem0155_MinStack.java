package Medium;

import java.util.Stack;

// Time Complexity: O(1) for all operations (push, pop, top, getMin)
// Space Complexity: O(n) because used stack to store {value, minValue}
class MinStack {
    // stack with int array which will hold {value, minValue}
    Stack<int[]> stack = new Stack<>();

    // push operation
    public void push(int val) {
        // Getting the minimum value for current position
        // if stack is empty then current element will be minimum
        // otherwise get the minimum from val and stack.peek()[1]
        int min = stack.isEmpty() ? val : Math.min(val, stack.peek()[1]);

        // push both val and min in the stack
        stack.push(new int[] { val, min });
    }

    // pop operation
    public void pop() {
        // pop top element out from the stack
        stack.pop();
    }

    // top function (get top element from stack without removing that)
    public int top() {
        // getting the top element from the stack without removing it
        // and it is stored at 0th index of top element
        return stack.peek()[0];
    }

    // getMin function (get minimum value from the stack in O(1) time)
    public int getMin() {
        // Getting the minimum value in O(1) stored at 1st index of top element
        return stack.peek()[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
