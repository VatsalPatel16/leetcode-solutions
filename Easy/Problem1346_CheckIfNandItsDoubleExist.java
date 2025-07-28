package Easy;

import java.util.HashSet;
import java.util.Set;

// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public boolean checkIfExist(int[] arr) {
        // Initialize hashset
        Set<Integer> set = new HashSet<>();

        // Traverse through all elements of arr
        for (int n : arr) {
            // Check for the element in set
            if (set.contains(2 * n) || (n % 2 == 0 && set.contains(n / 2)))
                return true;

            set.add(n);
        }
        // if N and its double not found then return false
        return false;
    }
}