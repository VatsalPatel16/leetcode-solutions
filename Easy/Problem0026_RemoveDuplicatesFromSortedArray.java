package Easy;

// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public int removeDuplicates(int[] nums) {
        // j pointer to store unique element in array at first
        int j = 1;
        // Iterate over length of nums
        for (int i = 1; i < nums.length; i++) {
            // if current and prev element are not same
            // that means we encounterd unique element
            if (nums[i] != nums[i - 1]) {
                // Put that at position of j pointer
                nums[j] = nums[i];
                // and increment j
                j++;
            }
        }
        return j;
    }
}