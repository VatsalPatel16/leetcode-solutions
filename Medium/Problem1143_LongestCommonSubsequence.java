package Medium;

// Time Complexity: O(n * m)
// Space Complexity: O(n * m)
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // Solution using Tabulation method

        int n = text1.length(), m = text2.length();
        // dp array (2D table)
        int[][] dp = new int[n + 1][m + 1];

        // outer loop
        for (int i = 0; i <= n; i++) {
            // inner loop
            for (int j = 0; j <= m; j++) {
                // if any of the index(i or j) is equal to 0 then set dp[i][j] = 0
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
                // or else if text1.charAt(i - 1) is equal to text2.charAt(j - 1)
                // store dp[i - 1][j - 1] + 1 in dp[i][j]
                else if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                // otherwise store max(dp[i - 1][j], dp[i][j - 1]) in dp[i][j]
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // dp[n][m] will be the ans
        return dp[n][m];
    }
}