package Medium;

import java.util.Arrays;

// Time Complexity: O(n * amount)
// Space Complexity: O(amount)
class Solution {
    public int coinChange(int[] coins, int amount) {
        // dp array
        int[] dp = new int[amount + 1];
        // Filling the dp array with max value of Integer
        Arrays.fill(dp, Integer.MAX_VALUE);
        // Base case: No coins needed to make sum 0
        dp[0] = 0;

        // Filling the dp table
        // Iterate over each coin
        for (int coin : coins) {
            // for each coin traverse from i = coin to i <= amount
            for (int i = coin; i <= amount; i++) {
                if (dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }

        // if dp[amount] is equal to max value of Integer then return -1
        // otherwise return dp[amount] which will be our answer
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}