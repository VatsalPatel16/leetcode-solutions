package Hard;

import java.util.Stack;

// Time Complexity: O(n)
// Space Complexity: O(n) 
// stack based approach
class Solution {
    public int longestValidParentheses(String s) {
        // res variable to store output
        int res = 0;

        Stack<Integer> stack = new Stack<>();
        // push -1 in the stack
        stack.push(-1);

        // Iterate over given String s
        for (int i = 0; i < s.length(); i++) {
            // if current element is '(' then push its index in stack
            if (s.charAt(i) == '(') {
                stack.push(i);
            }
            // otherwise if current element is ')'
            // then pop out top element from stack
            else {
                stack.pop();

                // if stack is not empty then update res
                if (!stack.isEmpty()) {
                    res = Math.max(res, i - stack.peek());
                }
                // otherwise push current index in the stack
                else {
                    stack.push(i);
                }
            }
        }

        return res;
    }
}