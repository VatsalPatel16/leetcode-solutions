package Easy;

// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public int possibleStringCount(String word) {
        int n = word.length();
        // res to store output
        int res = 1;

        // Iterate over given string word
        for (int i = 1; i < n; i++) {
            // if previous char is equal to current char
            // then increment res
            if (word.charAt(i - 1) == word.charAt(i)) {
                res++;
            }
        }

        return res;
    }
}