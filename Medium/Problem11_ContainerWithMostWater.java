package Medium;

// Time Complexity: O(n)
// Space Complexity: O(1)
class Problem11_ContainerWithMostWater {
    public int maxArea(int[] height) {
        // res to store output
        int res = 0;

        // Two pointers left & right
        int left = 0, right = height.length - 1;
        // while both pointers don't cross each other do so
        while (left < right) {
            // Calculate area of water
            int area = (right - left) * Math.min(height[left], height[right]);
            res = Math.max(res, area); // Maximizing the res

            // if element at left is less than or equal to element at right
            // increment left pointer
            if (height[left] <= height[right]) {
                left++;
            }
            // Otherwise decrement right pointer
            else {
                right--;
            }
        }

        return res;
    }
}