package Medium;

import java.util.Arrays;

// Time Complexity: O(n^2)
// Space Complexity: O(1)
class Solution {
    public int triangleNumber(int[] nums) {
        int n = nums.length;
        int res = 0; // res to store output

        // sorting the array
        Arrays.sort(nums);

        // Iterate from 3rd element to last element
        for (int i = 2; i < n; i++) {
            // Two pointers l & r
            int l = 0, r = i - 1;

            // while both pointers don't cross each other do so
            while (l < r) {
                // Checking for Triangle condition
                // if true update res and decrement r pointer
                if (nums[l] + nums[r] > nums[i]) {
                    res += (r - l);
                    r--;
                }
                // otherwise increment l pointer
                else {
                    l++;
                }
            }
        }

        return res;
    }
}