package Hard;

// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;

        // if length of the prices array is zero
        // in that case return 0
        if (n == 0) {
            return 0;
        }

        // dp array (table)
        int[][] dp = new int[3][n];

        for (int t = 1; t <= 2; t++) {
            // best price to buy before making transaction 't'
            int maxDiff = -prices[0];
            for (int d = 1; d < n; d++) {
                // get the value of dp[t][d]
                dp[t][d] = Math.max(dp[t][d - 1], prices[d] + maxDiff);
                // update maxDiff
                maxDiff = Math.max(maxDiff, dp[t - 1][d] - prices[d]);
            }
        }

        // at last dp[2][n - 1] will be our result
        return dp[2][n - 1];
    }
}