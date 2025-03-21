package Medium;

// Time Complexity: O(n * m)
// Space Complexity: O(n * m)
class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        // 2D dp array (table)
        int[][] dp = new int[n + 1][m + 1];

        // outer loop
        for (int i = 0; i <= n; i++) {
            // inner loop
            for (int j = 0; j <= m; j++) {
                // if i is equal to 0, then set dp[i][j] = j
                if (i == 0) {
                    dp[i][j] = j;
                }
                // if j is equal to 0, then set dp[i][j] = i
                else if (j == 0) {
                    dp[i][j] = i;
                }
                // if characters match, no operation needed
                else if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                // if characters doesn't match
                // take min of(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1])
                else {
                    dp[i][j] = 1 + Math.min(dp[i][j - 1],
                            Math.min(dp[i - 1][j],
                                    dp[i - 1][j - 1]));
                }
            }
        }

        return dp[n][m];
    }
}