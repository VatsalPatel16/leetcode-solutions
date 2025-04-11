package Medium;

import java.util.HashSet;
import java.util.Set;

// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public int partitionString(String s) {
        // Hashset to keep track characters in the current substring
        Set<Character> seen = new HashSet<>();
        // count variable to keep track of partitions
        int count = 0;

        // Iterate over given String s
        for (char c : s.toCharArray()) {
            // if set contains current char c
            // then increment count and reset the set
            if (seen.contains(c)) {
                count++;
                seen.clear();
            }
            // add current char c in the set
            seen.add(c);
        }

        // add the last partition if any characters are left in the set
        if (!seen.isEmpty()) {
            count++;
        }

        return count;
    }
}