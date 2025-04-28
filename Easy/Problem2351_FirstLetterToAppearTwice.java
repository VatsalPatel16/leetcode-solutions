package Easy;

import java.util.HashSet;
import java.util.Set;

// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public char repeatedCharacter(String s) {
        // Set to check for first repeating char in string
        Set<Character> set = new HashSet<>();

        for (char c : s.toCharArray()) {
            // if current char already exist in set return that char
            if (set.contains(c)) {
                return c;
            }
            // Otherwise add current char in set
            set.add(c);
        }

        return '0';
    }
}