package Easy;

import java.util.HashSet;
import java.util.Set;

// Time Complexity: O(n + m)
// Space Complexity: O(n)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        // resSet to store output and avoid duplicate
        Set<Integer> resSet = new HashSet<>();
        // set s to store element of array nums1
        Set<Integer> s = new HashSet<>();

        // Storing element of array nums1 in set s
        for (int val : nums1) {
            s.add(val);
        }

        // Checking for intersection condition
        for (int val : nums2) {
            if (s.contains(val)) {
                resSet.add(val);
            }
        }

        // Converting resSet into res array
        int[] res = new int[resSet.size()];

        int i = 0;
        for (int num : resSet) {
            res[i++] = num;
        }

        return res;
    }
}