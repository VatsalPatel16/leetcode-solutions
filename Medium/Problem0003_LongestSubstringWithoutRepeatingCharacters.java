package Medium;

import java.util.HashSet;
import java.util.Set;

// Time Complexity: O(n)
// Space Complexity: O(min(n, charset_size))
class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Converting string s to char array
        char[] str = s.toCharArray();

        // set to keep track of chars in current window
        Set<Character> charSet = new HashSet<>();
        // pointer l for traversal and res to store output
        int l = 0, res = 0;

        // Iterate over str array
        for (int r = 0; r < str.length; r++) {
            // while charSet contains str[r] then remove
            // element str[l] and increment l pointer
            while (charSet.contains(str[r])) {
                charSet.remove(str[l]);
                l++;
            }
            // add str[r] in charSet
            charSet.add(str[r]);
            // update the res
            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}