package Easy;

// Time Complexity: O(n), where n is the number of elements in the array
// Space Complexity: O(1)
class Solution {
    public void moveZeroes(int[] nums) {
        // Getting length of array
        int len = nums.length;
        // pointer variable to get all non-zero element in front
        int pointer = 0;

        // Getting all the non-zero element in front
        for (int i = 0; i < len; i++) {
            if (nums[i] != 0) {
                // Doing swaps with zeros
                int temp = nums[i];
                nums[i] = nums[pointer];
                nums[pointer] = temp;
                pointer++;
            }
        }
    }
}