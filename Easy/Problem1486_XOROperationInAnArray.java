package Easy;

// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public int xorOperation(int n, int start) {
        // res to store output
        int res = 0;

        // Iterate from 0 to n
        for (int i = 0; i < n; i++) {
            // update res with (start + (2 * i))
            res ^= (start + (2 * i));
        }

        return res;
    }
}