package Easy;

// Time Complexity: O(m + n)
// Space Complexity: O(1)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // pointers i, j & k
        int i = m - 1, j = n - 1, k = m + n - 1;

        // while i and j is greater than or equal to 0 do so
        while (i >= 0 && j >= 0) {
            // if element in num1 is greater than num2
            // add element from num1 at kth position of num1
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            }
            // otherwise add element from num2 into num1 at kth position
            else {
                nums1[k--] = nums2[j--];
            }
        }

        // if any element remaining from num1 then add it
        while (i >= 0) {
            nums1[k--] = nums1[i--];
        }
        // if any element remaining from num2 then add it
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}