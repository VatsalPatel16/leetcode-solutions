package Easy;

import java.util.HashSet;
import java.util.Set;

// Time Complexity: O(n)
// Space Complexity: O(k)
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        // Set to store element from nums
        // It will maintain window of size k
        Set<Integer> set = new HashSet<>();

        // Iterate over nums array
        for (int i = 0; i < n; i++) {
            // if set contains value nums[i] then return true
            if (set.contains(nums[i])) {
                return true;
            }
            // add current element in set
            set.add(nums[i]);

            // if size of set is greater then k then remove nums[i - k]
            // from the set
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }

        return false;
    }
}