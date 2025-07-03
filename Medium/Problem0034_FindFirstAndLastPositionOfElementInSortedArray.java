package Medium;

// Time Complexity: O(log n)
// Space Complexity: O(1)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        // Finding first and last position using methods
        // findFirst and findLast
        int first = findFirst(nums, target);
        int last = findLast(nums, target);

        // return that as an array
        return new int[] { first, last };
    }

    // findFirst method
    private int findFirst(int[] nums, int target) {
        // Simple binary search
        int l = 0, r = nums.length - 1;
        int ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) {
                // if found target at mid then store mid in ans
                // and update r to mid - 1
                ans = mid;
                r = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return ans;
    }

    // findLast method
    private int findLast(int[] nums, int target) {
        // Simple binary search
        int l = 0, r = nums.length - 1;
        int ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) {
                // if found target at mid then store mid in ans
                // and update l to mid + 1
                ans = mid;
                l = mid + 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return ans;
    }
}