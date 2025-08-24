package Easy;

import java.util.Stack;

// Time Complexity: O(1) for push & empty, O(1) Amortized and O(n) Worst Case for pop & peek
// Space Complexity: O(n)
class MyQueue {

    // Using two stacks to implement queue
    private Stack<Integer> sIn;
    private Stack<Integer> sOut;

    public MyQueue() {
        // Initialize both stacks
        sIn = new Stack<>();
        sOut = new Stack<>();
    }

    public void push(int x) {
        // for push operation simply push x into sIn stack
        sIn.push(x);
    }

    public int pop() {
        // for pop first check if sOut stack is empty or not
        if (sOut.isEmpty()) {
            // if yes then move all the elements from sIn to sOut
            while (!sIn.isEmpty()) {
                sOut.push(sIn.pop());
            }
        }
        // then pop top element from the sOut stack
        return sOut.pop();
    }

    public int peek() {
        // for peek operation it is same as pop just don't pop top element from sOut
        if (sOut.isEmpty()) {
            while (!sIn.isEmpty()) {
                sOut.push(sIn.pop());
            }
        }
        // peek into top element of sOut stack
        return sOut.peek();
    }

    public boolean empty() {
        // check both sIn and sOut stack for empty method
        return sIn.isEmpty() && sOut.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */