package Easy;

// Time Complexity: O(log(columnNumber))
// Space Complexity: O(log(columnNumber)) both with base 26
class Solution {
    public String convertToTitle(int columnNumber) {
        // res to store output
        StringBuilder res = new StringBuilder();

        // while columnNumber is greater than 0 do so
        while (columnNumber > 0) {
            // decrementing columnNumber by 1 before doing mod
            // operation to correctly align it with 'A'
            columnNumber--;
            // Getting the remainder
            int remainder = columnNumber % 26;
            // and append the character to res
            res.append((char) ('A' + remainder));
            // divide columnNumber by 26 for next iteration
            columnNumber /= 26;
        }

        // the answer will be stored in reverse during while loop
        // so reverse that and convert it to string
        return res.reverse().toString();
    }
}