package Medium;

// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public void sortColors(int[] nums) {
        // DNF method
        int low = 0, mid = 0, high = nums.length - 1;
        // loop while mid and high don't cross each other
        while (mid <= high) {
            // if element at mid is 0 then swap it with low and increment both pointer
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            }
            // or else if element at mid is 1 then increment mid
            else if (nums[mid] == 1) {
                mid++;
            }
            // otherwise element is 2 at mid and swap that with high and decrement high
            else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    // method to swap values in array
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}