package Easy;

import java.util.ArrayList;
import java.util.List;

// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        // res list to store output
        List<Integer> res = new ArrayList<>();

        // Iterate over nums array
        for (int i = 0; i < n; i++) {
            // Using in-place marking to check which elements are missing
            // First store abs value of nums[i] in variable x
            int x = Math.abs(nums[i]);
            // decrement value of x
            x--;
            // if nums[x] is greater than 0 then mark it as negative
            if (nums[x] > 0) {
                nums[x] = -nums[x];
            }
        }

        // Second loop
        for (int i = 0; i < n; i++) {
            // for any i if nums[i] is positive then (i + 1) is missing
            // add that in res list
            if (nums[i] > 0) {
                res.add(i + 1);
            }
        }

        return res;
    }
}