package Easy;

// Time Complexity: O(max(m, n))
// Space Complexity: O(max(m, n)), where m = a.length() and n = b.length()
class Solution {
    public String addBinary(String a, String b) {
        // StringBuilder to store result
        StringBuilder res = new StringBuilder();
        // Two pointer i and j to traverse over each String
        int i = a.length() - 1, j = b.length() - 1;
        // variable carry to keep track of carry at each iteration
        int carry = 0;

        // while i or j is greater than or equal to zero or carry is not equal to
        // zero then do so
        while (i >= 0 || j >= 0 || carry != 0) {
            // get the bit from String a and String b
            // if bit is not available then take 0 in that case
            int bitA = i >= 0 ? a.charAt(i) - '0' : 0;
            int bitB = j >= 0 ? b.charAt(j) - '0' : 0;

            // use bitA, bitB and carry to get the sum
            int sum = bitA + bitB + carry;
            // sum % 2 will be our bit
            res.append(sum % 2);
            // and carry would be sum / 2
            carry = sum / 2;

            // decrement both pointers
            i--;
            j--;
        }

        // reverse the res and convert it to String
        return res.reverse().toString();
    }
}