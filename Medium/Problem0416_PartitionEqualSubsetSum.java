package Medium;

import java.util.Arrays;

// Time Complexity: O(n * sum)
// Space Complexity: O(n * sum)
class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        // Getting sum of elements of array nums
        int sum = Arrays.stream(nums).sum();

        // if sum is odd that means partition is not possible
        // in that case return false
        if (sum % 2 != 0) {
            return false;
        }

        // divide sum by 2
        sum = sum / 2;
        // 2D dp array (table)
        boolean[][] dp = new boolean[n + 1][sum + 1];

        // if sum is zero then answer is true (empty subset)
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        // Filling the dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                // if j is less than nums[i - 1]
                if (j < nums[i - 1]) {
                    // Exclude the element
                    dp[i][j] = dp[i - 1][j];
                }
                // otherwise
                else {
                    // Exclude or include element
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        // dp[n][sum] will be our answer
        return dp[n][sum];
    }
}