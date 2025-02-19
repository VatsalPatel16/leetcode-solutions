package Easy;

// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public int returnToBoundaryCount(int[] nums) {
        // Variable boundary to keep track of where the ant is
        // and count which will give the output how many times ant returned to boundary
        int boundary = 0, count = 0;

        // Iterate over nums array
        for (int n : nums) {
            // add current move of ant to boundary
            boundary += n;
            // if ant is on the boundary increment count
            if (boundary == 0) {
                count++;
            }
        }
        return count;
    }
}