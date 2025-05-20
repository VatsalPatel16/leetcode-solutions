package Easy;

// Time Complexity: O(max(n, m)), where n is the length of word1 and m is the length of word2
// Space Complexity: O(n + m), output string
class Solution {
    public String mergeAlternately(String word1, String word2) {
        // StringBuilder to store output
        StringBuilder res = new StringBuilder();
        // Getting max length of two strings
        int maxLen = Math.max(word1.length(), word2.length());

        // Iterate till end of max length
        for (int i = 0; i < maxLen; i++) {
            // First add char from word1 if it is not end yet
            if (i < word1.length())
                res.append(word1.charAt(i));

            // then add char from word2 if it is not end yet
            if (i < word2.length())
                res.append(word2.charAt(i));
        }

        return res.toString();
    }
}