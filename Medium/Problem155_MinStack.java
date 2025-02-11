package Medium;

import java.util.Stack;

// Time Complexity: O(1) for all operations (push, pop, top, getMin)
// Space Complexity: O(n) because used two stacks (stack & minVal)
class MinStack {
    // Using two stacks
    // 1) normal stack
    // 2) minVal which will keep track of minimum value in the stack
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minVal = new Stack<>();

    // push operation
    public void push(int val) {
        // push given val into stack
        stack.push(val);

        // for minVal check if it is empty
        // if yes then push given val in the minVal stack
        if (minVal.isEmpty()) {
            minVal.push(val);
        }
        // if not empty then push minimum value between val and minVal.peek() (top
        // element of minVal stack)
        else {
            minVal.push(Math.min(val, minVal.peek()));
        }
    }

    // pop operation
    public void pop() {
        // popping top element from both stacks
        stack.pop();
        minVal.pop();
    }

    // top function (get top element from stack without removing that)
    public int top() {
        // using peek operation to get the top of stack
        return stack.peek();
    }

    // getMin function (get minimum value from the stack in O(1) time)
    public int getMin() {
        // using peek operation on minVal stack which keep track minimum value in stack
        return minVal.peek();
    }
}
