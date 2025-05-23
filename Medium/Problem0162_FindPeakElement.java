package Medium;

// Time Complexity: O(log n)
// Space Complexity: O(1)
class Solution {
    public int findPeakElement(int[] nums) {
        int len = nums.length;

        // Check for edge cases
        // Only one element in nums array
        if (len == 1)
            return 0;

        // first element is peak element
        if (nums[0] > nums[1])
            return 0;
        // last element is peak element
        if (nums[len - 1] > nums[len - 2])
            return len - 1;

        int l = 1, r = len - 2;
        // Iterate till both pointer don't cross each other
        while (l <= r) {
            int mid = l + (r - l) / 2; // Getting mid index

            // if mid element is peak element then return mid index
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])
                return mid;

            // if mid element is less than next element then update left pointer
            if (nums[mid] < nums[mid + 1])
                l = mid + 1;
            // Otherwise update right pointer
            else
                r = mid - 1;
        }
        return -1;
    }
}