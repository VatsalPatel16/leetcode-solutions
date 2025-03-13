package Medium;

import java.util.Stack;

// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public String removeStars(String s) {
        // stack data structure to efficiently remove char from the String when
        // * encountered
        Stack<Character> stack = new Stack<>();

        // Traverse over String s
        for (char c : s.toCharArray()) {
            // if current char is * then pop char out of the stack
            if (c == '*') {
                stack.pop();
            } else {
                // otherwise push char into stack
                stack.push(c);
            }
        }

        // StringBuilder for the result
        StringBuilder res = new StringBuilder();

        // while stack is not empty append char to res
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }

        // reverse the res and convert it to String
        return res.reverse().toString();
    }
}