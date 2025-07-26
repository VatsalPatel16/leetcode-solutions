package Easy;

import java.util.Stack;

// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public int calPoints(String[] operations) {
        // stack to store score
        Stack<Integer> stack = new Stack<>();

        // Iterate over each operation
        for (String op : operations) {
            // if current operation is "+" then
            // get last two scores from stack, add them and push into stack
            if (op.equals("+")) {
                int val1 = stack.pop();
                int val2 = stack.peek();
                int total = val1 + val2;

                stack.push(val1);
                stack.push(total);
            }
            // else if operation is "D" then
            // get the top element from the stack and double it
            // and push that into stack
            else if (op.equals("D")) {
                stack.push(2 * stack.peek());
            }
            // else if operation is "C" then
            // discard the last score
            else if (op.equals("C")) {
                stack.pop();
            }
            // otherwise it will be score, so push that score into stack
            else {
                stack.push(Integer.parseInt(op));
            }
        }

        // Iterate till stack is empty and get the total score
        // store it into res
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }

        return res;
    }
}