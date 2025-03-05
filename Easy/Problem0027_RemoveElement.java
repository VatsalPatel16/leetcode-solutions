package Easy;

// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public int removeElement(int[] nums, int val) {
        // Pointer to get all element != val in front
        int pos = 0;

        // Iterate over the nums array
        for (int i = 0; i < nums.length; i++) {
            // if current element is not equal to val then move that element in front
            if (nums[i] != val) {
                nums[pos] = nums[i];
                pos++;
            }
        }

        return pos;
    }
}