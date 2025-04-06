package Medium;

import java.util.List;

// Time Complexity: O(n * m), n = length of the string, m = number of words in the dictionary (plus substring comparisons)
// Space Complexity: O(n)
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        // dp array
        boolean[] dp = new boolean[n + 1];
        // dp[0] is equal to true because empty string is always breakable
        dp[0] = true;

        // Iterate over String s
        for (int i = 1; i <= n; i++) {
            // Iterate over list wordDict
            for (String word : wordDict) {
                int start = i - word.length();
                // check if the current word is present and
                // prefix before the word is also breakable
                if (start >= 0 && dp[start] &&
                        s.substring(start, start + word.length()).equals(word)) {
                    // if it's true then set dp[i] to true and break out the loop
                    dp[i] = true;
                    break;
                }
            }
        }

        // Finally, dp[n] will be our result
        return dp[n];
    }
}