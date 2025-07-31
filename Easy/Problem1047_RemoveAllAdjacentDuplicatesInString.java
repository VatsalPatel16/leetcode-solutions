package Easy;

import java.util.Stack;

// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public String removeDuplicates(String s) {
        // using stack to remove all adjacent duplicates
        Stack<Character> stack = new Stack<>();

        // iterate over given string s
        for (char c : s.toCharArray()) {
            // if stack is not empty and current char is equal to
            // top element of stack then pop top element
            if (!stack.isEmpty() && c == stack.peek()) {
                stack.pop();
            }
            // otherwise push current char in stack
            else {
                stack.push(c);
            }
        }

        // res to store output
        StringBuilder res = new StringBuilder();
        for (char c : stack) {
            res.append(c);
        }

        // return res as string
        return res.toString();
    }
}