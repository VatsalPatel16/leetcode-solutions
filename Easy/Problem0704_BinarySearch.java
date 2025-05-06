package Easy;

// Time Complexity: O(log n)
// Space Complexity: O(1)
class Solution {
    public int search(int[] nums, int target) {
        // Two pointer left and right
        // left -> at the start of the array
        // right -> at the end of the array
        int left = 0;
        int right = nums.length - 1;

        // While both pointers don't cross each other do so
        while (left <= right) {
            // find the mid index using left and right
            int mid = (left + right) / 2;

            // if found target at mid then return mid
            if (nums[mid] == target)
                return mid;

            // or else if value at mid is less then target then update left to (mid + 1)
            else if (nums[mid] < target)
                left = mid + 1;

            // otherwise value at mid is greater then target in that case update
            // right to (mid - 1)
            else
                right = mid - 1;
        }

        // if target not found in the array then return -1
        return -1;
    }
}
