package Easy;

// Time Complexity: O(n * m) where, n = number of strings in strs and m = length of the shortest string in strs
// Space Complexity: O(1)
class Solution {
    public String longestCommonPrefix(String[] strs) {
        // if strs is empty then return empty string
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Iterate char by char on first string from strs
        for (int i = 0; i < strs[0].length(); i++) {
            // get the char
            char c = strs[0].charAt(i);

            // Check with all the other strings
            for (int j = 1; j < strs.length; j++) {
                // Check if we've reached the end of a string or there's a mismatch
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    // if end or mismatch then return substring from (0, i)
                    return strs[0].substring(0, i);
                }
            }
        }

        // All char matched in all the strings
        return strs[0];
    }
}