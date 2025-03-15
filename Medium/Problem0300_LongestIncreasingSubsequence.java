package Medium;

import java.util.*;

// Time Complexity: O(n log n)
// Space Complexity: O(n)
class Solution {
    public int lengthOfLIS(int[] nums) {
        // list to maintain increasing subsequence
        List<Integer> list = new ArrayList<>();

        // Iterate over array nums
        for (int n : nums) {
            // find the index using binary search
            int index = Collections.binarySearch(list, n);

            // if n not found in list then it will return
            // -(insertion point) - 1
            if (index < 0) {
                // convert it into correct index
                index = -(index + 1);
            }

            // if index is equal to size of list then append n to list
            if (index == list.size()) {
                list.add(n);
            }
            // otherwise update index with n
            else {
                list.set(index, n);
            }
        }

        // return size of list which will be LIS length
        return list.size();
    }
}