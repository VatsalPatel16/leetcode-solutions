package Medium;

import java.util.Stack;

// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public int evalRPN(String[] tokens) {
        // stack to store values from given tokens
        Stack<Integer> stack = new Stack<>();

        // Iterate over given array of String tokens
        for (String s : tokens) {
            // if current s is a number then push that into the stack
            if (s.matches("-?\\d+")) {
                stack.push(Integer.parseInt(s));
            }
            // otherwise it will be operator
            else {
                // pop top two element out from the stack
                int num1 = stack.pop();
                int num2 = stack.pop();

                // swich case to check for the operator
                // match that and push back to stack after operation between nums
                switch (s) {
                    case "+":
                        stack.push(num2 + num1);
                        break;

                    case "-":
                        stack.push(num2 - num1);
                        break;

                    case "*":
                        stack.push(num2 * num1);
                        break;

                    case "/":
                        stack.push(num2 / num1);
                        break;
                }
            }
        }

        // The remaining element in the stack will be the result of RPN
        return stack.pop();
    }
}