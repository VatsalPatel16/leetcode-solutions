package Easy;

// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        // Two pointers l & r to move all the even integers
        // at the beginning of the array
        int l = 0, r = 0;

        // while r is less than length of nums array do so
        while (r < nums.length) {
            // check if number at r pointer is even or not
            // if yes then swap that value with value at l pointer
            // and increment both pointers
            if ((nums[r] % 2) == 0) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
                r++;
            }
            // otherwise only increment r pointer
            else {
                r++;
            }
        }

        return nums;
    }
}