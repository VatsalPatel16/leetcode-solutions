package Easy;

// Time Complexity: O(log n)
// Space Complexity: O(1)
class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        // Two pointers l & r (using binary search)
        int l = 0, r = n - 1;

        // while l is less than or equal to r do so
        while (l <= r) {
            // Calculate mid
            int mid = l + (r - l) / 2;

            // check if nums[mid] is equal to target
            // yes, then return mid
            if (nums[mid] == target) {
                return mid;
            }
            // or else if nums[mid] is less then target
            // then update l pointer to (mid + 1)
            else if (nums[mid] < target) {
                l = mid + 1;
            }
            // otherwise update r pointer to (mid - 1)
            else {
                r = mid - 1;
            }
        }

        // if target not found then l will be insertion position of the target
        return l;
    }
}