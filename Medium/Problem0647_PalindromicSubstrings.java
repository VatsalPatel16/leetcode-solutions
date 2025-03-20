package Medium;

// Time Complexity: O(n^2)
// Space Complexity: O(1)
class Solution {
    public int countSubstrings(String s) {
        // res variable to keep track of count of palindromic substrings
        int n = s.length(), res = 0;

        // Iterate over given String s
        for (int i = 0; i < n; i++) {
            // This loop will run two times for each index
            // 1. for odd length
            // 2. for even length
            for (int j = 0; j < 2; j++) {
                // Two pointers l & r
                int l = i, r = i + j;
                // while charAt l & r are same expand in both directions
                while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                    // increment res
                    res++;

                    // update l & r pointers
                    l--;
                    r++;
                }
            }
        }

        return res;
    }
}