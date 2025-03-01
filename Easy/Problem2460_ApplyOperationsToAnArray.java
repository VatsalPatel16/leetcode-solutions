package Easy;

// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public int[] applyOperations(int[] nums) {
        // performing given operation
        // If nums[i] == nums[i + 1], then multiply nums[i] by 2
        // and set nums[i + 1] to 0.
        // Otherwise, you skip this operation.
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                nums[i] *= 2;
                nums[i + 1] = 0;
            }
        }

        // Moving all zeros to the end
        // Initialize count variable
        int count = 0;
        // Iterate over nums array
        for (int i = 0; i < nums.length; i++) {
            // If non-zero element occurs then perform swap
            // of element at current position and element at position count
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[count];
                nums[count] = temp;
                count++;
            }
        }

        return nums;
    }
}
