package Hard;

import java.util.Stack;

// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length, res = 0;
        // Monotonic stack
        Stack<Integer> stack = new Stack<>();
        int[] NSR = new int[n]; // Array for Next Smaller Right(NSR)
        int[] NSL = new int[n]; // Array for Next Smaller Left(NSL)

        // Computing Next Smaller Right for each value of heights array
        for (int i = n - 1; i >= 0; i--) {
            // while stack is not empty and element at index stack.peek()
            // is greater than or equal to current element
            // pop element out from the stack
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            // if stack is empty that means no smaller element
            // on the right side of that element
            // its NSR will be n
            if (stack.isEmpty()) {
                NSR[i] = n;
            }
            // otherwise its NSR will be stack.peek()
            else {
                NSR[i] = stack.peek();
            }

            // at each iteration push current index in the stack
            stack.push(i);
        }

        // Before using stack again for NSL clear the stack
        stack.clear();

        // Similarly compute NSL for each element
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                NSL[i] = -1;
            } else {
                NSL[i] = stack.peek();
            }

            stack.push(i);

            // Compute width using NSR and NSL
            int width = NSR[i] - NSL[i] - 1;
            // And maximize the result
            res = Math.max(res, heights[i] * width);
        }

        return res;
    }
}