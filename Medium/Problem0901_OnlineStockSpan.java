package Medium;

import java.util.Stack;

// Time Complexity : O(1) amortized, O(N) worst case
// Space Complexity : O(n)
class StockSpanner {
    // Stack to store {price, span}
    Stack<int[]> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        // Default span for new price
        int span = 1;

        // Pop all smaller or equal prices and calculate span
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }

        // Push current price and span in the stack
        stack.push(new int[] { price, span });

        return span;
    }
}

// Amortized time complexity refers to the average time per operation over a
// sequence of operations,
// even if some individual operations take longer. It helps analyze algorithms
// that have occasional expensive operations but are efficient in the long run.

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */