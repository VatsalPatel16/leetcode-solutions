package Easy;

import java.util.HashSet;
import java.util.Set;

// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public boolean containsDuplicate(int[] nums) {
        // Set to store elements from array and check for duplicate
        Set<Integer> val = new HashSet<>();

        // Iterate through array nums
        for (int num : nums) {
            // if set contains current element that means array contains duplicate
            // return true in that case
            if (val.contains(num)) {
                return true;
            }
            // Adding current element in the set
            val.add(num);
        }
        // if not found duplicate then return false
        return false;
    }
}
