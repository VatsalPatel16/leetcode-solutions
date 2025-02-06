package Easy;

import java.util.HashMap;

// Time Complexity: O(n)
// Space Complexity: O(n)
class Problem1_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        // HashMap to store numbers and their indices
        HashMap<Integer, Integer> num = new HashMap<>();

        // Iterate thorugh the array
        for (int i = 0; i < nums.length; i++) {
            // find the complement of current number using target value
            int complement = target - nums[i];

            // check if current number is already in the map
            // if yes then store its index in variable complementIndex
            Integer complementIndex = num.get(nums[i]);
            if (complementIndex != null) {
                // if found then return indices
                return new int[] { i, complementIndex };
            }

            // if not then store complement and i in the map
            num.put(complement, i);
        }

        // if no solution found then return empty array
        return new int[] {};
    }
}