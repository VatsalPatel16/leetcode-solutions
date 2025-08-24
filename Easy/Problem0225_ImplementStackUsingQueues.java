package Easy;

import java.util.LinkedList;
import java.util.Queue;

// Time Complexity: O(n) for push method, O(1) for pop, top, empty method
// Space Complexity: O(n)
class MyStack {
    // Using single queue to implement stack
    Queue<Integer> q;

    public MyStack() {
        // Initialize queue
        q = new LinkedList<>();
    }

    public void push(int x) {
        // add element in the queue
        q.offer(x);
        int size = q.size();
        // since queue is FIFO we have to rotate all the elements
        // in the queue until the last one added comes to the front
        for (int i = 0; i < size - 1; i++) {
            q.offer(q.poll());
        }
    }

    public int pop() {
        // since we have already rotated queue to implement stack
        // just remove the element from the front of the queue
        return q.poll();
    }

    public int top() {
        // to get the top element just peek into first element in the queue
        return q.peek();
    }

    public boolean empty() {
        // using isEmpty method to check if queue is empty or not
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */