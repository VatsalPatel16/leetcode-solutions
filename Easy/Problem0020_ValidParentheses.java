package Easy;

import java.util.*;

// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public boolean isValid(String s) {
        // stack to check for valid parentheses as it gives us top element
        Stack<Character> stack = new Stack<>();
        // Map to store matching pairs
        Map<Character, Character> closeToOpen = new HashMap<>();
        closeToOpen.put(']', '[');
        closeToOpen.put('}', '{');
        closeToOpen.put(')', '(');

        // Iterate over given String s
        for (char c : s.toCharArray()) {
            // if current element is a closing bracket do this
            if (closeToOpen.containsKey(c)) {
                // if stack is not empty and
                // top element of stack and current element's value in the map are same
                // then pop top element from the stack
                if (!stack.isEmpty() && (stack.peek() == closeToOpen.get(c))) {
                    stack.pop();
                }
                // otherwise return false
                else {
                    return false;
                }
            }
            // if current element is not closing bracket then push that in stack
            else {
                stack.push(c);
            }
        }
        // if stack is empty then given String of parenthesis is valid
        // and if not then it is not valid
        return stack.isEmpty();
    }
}