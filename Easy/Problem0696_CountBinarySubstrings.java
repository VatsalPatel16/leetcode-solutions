package Easy;

// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public int countBinarySubstrings(String s) {
        // two variables prev and curr to keep track of
        // previous and current group
        int prev = 0, curr = 1;
        // ans to store the result
        int ans = 0;

        // Iterate over given string s
        for (int i = 1; i < s.length(); i++) {
            // if current and previous char both are same
            // then increment curr
            if (s.charAt(i - 1) == s.charAt(i)) {
                curr++;
            }
            // otherwise add min of prev and curr in ans
            // update prev = curr and reset curr to 1
            else {
                ans += Math.min(prev, curr);
                prev = curr;
                curr = 1;
            }
        }
        // at last add min of prev and curr in ans for final pair
        ans += Math.min(prev, curr);

        return ans;
    }
}