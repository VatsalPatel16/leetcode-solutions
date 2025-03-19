package Medium;

// Time Complexity: O(n^2)
// Space Complexity: O(1)
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        // variable start to keep track of starting index, and maxLen
        // to keep track of max length of the result
        int start = 0, maxLen = 1;

        // Iterate over String s
        for (int i = 0; i < n; i++) {
            // this loop will run two times for each index
            // 1. for odd length
            // 2. for even length
            for (int j = 0; j < 2; j++) {
                // two pointers
                int l = i, r = i + j;
                // if both charAt l & r are same then expand in both directions
                while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                    // and update start and maxLen
                    int currLen = r - l + 1;
                    if (currLen > maxLen) {
                        start = l;
                        maxLen = currLen;
                    }
                    // update pointers l & r
                    l--;
                    r++;
                }
            }
        }
        // substring from start to (start + maxLen) will be our result
        return s.substring(start, start + maxLen);
    }
}