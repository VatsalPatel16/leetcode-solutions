package Hard;

// Time Complexity: O(k * n)
// Space Complexity: O(k * n)
class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        // if length of prices array is 0
        // or k is eaual to 0 in that case return 0
        if (n == 0 || k == 0) {
            return 0;
        }

        // 2D dp array (table)
        int[][] dp = new int[k + 1][n];

        for (int t = 1; t <= k; t++) {
            // best price to buy before making transaction 't'
            int maxDiff = -prices[0];
            for (int d = 1; d < n; d++) {
                // get the value of dp[t][d]
                dp[t][d] = Math.max(dp[t][d - 1], prices[d] + maxDiff);
                // update maxDiff
                maxDiff = Math.max(maxDiff, dp[t - 1][d] - prices[d]);
            }
        }

        // dp[k][n - 1] will be our result
        return dp[k][n - 1];
    }
}