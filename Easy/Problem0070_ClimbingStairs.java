package Easy;

// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public int climbStairs(int n) {
        // if n is equal to 0 then no way to climb stairs
        if (n == 0)
            return 0;

        // if n is equal to 1 then only one way
        if (n == 1)
            return 1;

        // if n is equal to 2 then two ways(1 + 1 or 2)
        if (n == 2)
            return 2;

        // Three variables prev1, prev2 & curr
        int prev2 = 1, prev1 = 2, curr = 0;

        // Iterate from i is equal to 3 to n
        for (int i = 3; i <= n; i++) {
            // curr is equal to prev1 + prev2
            curr = prev1 + prev2;
            // at each iteration prev2 = prev1
            prev2 = prev1;
            // and prev1 = curr
            prev1 = curr;
        }

        // At last curr will be our answer
        return curr;
    }
}