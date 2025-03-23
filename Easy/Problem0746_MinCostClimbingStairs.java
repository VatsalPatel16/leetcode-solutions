package Easy;

// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        // if only one cost given return cost[0]
        if (n == 1) {
            return cost[0];
        }

        // set prev2 as cost[0] and prev1 as cost[1]
        int prev2 = cost[0], prev1 = cost[1];

        // Iterate from i = 2 till i < n
        for (int i = 2; i < n; i++) {
            // curr will be cost[i] + min of(prev1, prev2)
            int curr = cost[i] + Math.min(prev1, prev2);
            // at each iteration set prev2 as prev1
            prev2 = prev1;
            // and prev1 as curr
            prev1 = curr;
        }

        // min of(prev1, prev2) will be our result
        return Math.min(prev1, prev2);
    }
}