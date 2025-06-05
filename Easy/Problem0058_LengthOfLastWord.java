package Easy;

// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public int lengthOfLastWord(String s) {
        // trim to remove whitespace from both ends of the string
        s = s.trim();
        int n = s.length(), lastWordLen = 0;

        // Iterate from the end of the string
        for (int i = n - 1; i >= 0; i--) {
            // if found space then break out the loop
            if (s.charAt(i) == ' ')
                break;

            // Increment lastWordLen variable at each iteration
            lastWordLen++;
        }

        return lastWordLen;
    }
}