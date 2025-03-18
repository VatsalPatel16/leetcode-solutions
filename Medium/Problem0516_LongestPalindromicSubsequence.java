package Medium;

// Time Complexity: O(n^2)
// Space Complexity: O(n^2)
class Solution {
    public int longestPalindromeSubseq(String s) {
        // Converting s into StringBuilder and reverse it
        StringBuilder str = new StringBuilder(s);
        str.reverse();

        // Finding LCS of s and reverse of s
        return LCS(s, str.toString());
    }

    private int LCS(String s1, String s2) {
        int n = s1.length();
        // 2D dp array (table)
        int[][] dp = new int[n + 1][n + 1];

        // outer loop
        for (int i = 0; i <= n; i++) {
            // inner loop
            for (int j = 0; j <= n; j++) {
                // if any of the index(i, j) is equal to zero then set dp[i][j] = 0
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
                // or else if s1.charAt(i - 1) is equal to s2.charAt(j - 1)
                // set dp[i][j] equal to dp[i - 1][j - 1] + 1
                else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                // otherwise store max(dp[i - 1][j], dp[i][j - 1]) in dp[i][j]
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // at last dp[n][n] will be our result
        return dp[n][n];
    }
}