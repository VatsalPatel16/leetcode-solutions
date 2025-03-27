package Easy;

// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public boolean rotateString(String s, String goal) {
        // If length of both strings are different then return false
        if (s.length() != goal.length())
            return false;

        // s + s = "abcdeabcde" which contains goal if it is there
        return (s + s).contains(goal);
    }
}