package Easy;

// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public char findTheDifference(String s, String t) {
        // variable ans to store output
        char ans = 0;

        // using XOR operation because
        // a ^ a = 0
        // a ^ 0 = a
        // first XOR all elements of string s
        for (char c : s.toCharArray()) {
            ans ^= c;
        }

        // then XOR all elements of string t
        for (char c : t.toCharArray()) {
            ans ^= c;
        }

        // only the letter which is only in t will remain in the ans
        // after doing XOR operations
        return ans;
    }
}