package Easy;

import java.util.Arrays;

// Time Complexity: O(1), sorting 3 elements is constant time
// Space Complexity: O(1)
class Solution {
    public String triangleType(int[] nums) {
        // Sorting the three elements of nums array
        Arrays.sort(nums);

        // if triangle is not valid then in that case return none
        if (nums[0] + nums[1] <= nums[2]) {
            return "none";
        } else {
            // if all the sides are same then return "equilateral"
            if (nums[0] == nums[1] && nums[1] == nums[2]) {
                return "equilateral";
            }
            // if two sides are same then in that case return "isosceles"
            else if (nums[0] == nums[1] || nums[1] == nums[2] || nums[0] == nums[2]) {
                return "isosceles";
            }

            // and if all the sides are different then return "scalene"
            return "scalene";
        }
    }
}