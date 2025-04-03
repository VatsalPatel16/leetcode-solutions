package Medium;

// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public int numDecodings(String s) {
        int n = s.length();

        // if first char is 0 then it is invalid String 0 can't be decoded
        // so, return 0 in that case
        if (s.charAt(0) == '0') {
            return 0;
        }

        // two variables prev1 and prev2
        int prev1 = 1, prev2 = 1;

        // iterate from index 2 to i <= n
        for (int i = 2; i <= n; i++) {
            int curr = 0;

            // Single digit check
            if (s.charAt(i - 1) != '0') {
                curr += prev1;
            }

            // Two digit check
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigit >= 10 && twoDigit <= 26) {
                curr += prev2;
            }

            // at each iteration set prev2 as prev1
            prev2 = prev1;
            // and prev1 as curr
            prev1 = curr;
        }

        // at last prev1 will be our result
        return prev1;
    }
}