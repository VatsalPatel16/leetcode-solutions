package Medium;

import java.util.Stack;

// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public String decodeString(String s) {
        // numStack to store numbers encountered during iteration over s
        Stack<Integer> numStack = new Stack<>();
        // strStack to store String encountered during iteration over s
        Stack<StringBuilder> strStack = new Stack<>();
        // currNum and currStr will keep track of current values in the loop
        int currNum = 0;
        StringBuilder currStr = new StringBuilder();

        // iterate over given String s
        for (char c : s.toCharArray()) {
            // if current char is digit then store that in currNum
            if (Character.isDigit(c)) {
                currNum = currNum * 10 + Character.getNumericValue(c);
            }
            // or else if encountered opening bracket
            // push currNum in numStack and reset currNum
            // same for the currStr
            else if (c == '[') {
                numStack.push(currNum);
                strStack.push(new StringBuilder(currStr));

                currNum = 0;
                currStr.setLength(0);
            }
            // if encountered closing bracket then get top two elements from
            // both the stacks and append currStr to prevStr num times
            // then store that back to currStr
            else if (c == ']') {
                int num = numStack.pop();
                StringBuilder prevStr = strStack.pop();

                for (int i = 0; i < num; i++) {
                    prevStr.append(currStr);
                }

                currStr = prevStr;
            }
            // otherwise it will be char and append it to currStr
            else {
                currStr.append(c);
            }
        }

        // currStr will be our result in last
        return currStr.toString();
    }
}