package Easy;

// Time Complexity: O(log n)
// Space Complexity: O(1)
class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        // Getting overall missing count
        int missingCount = arr[n - 1] - n;

        // if missing count within array is less than k then it is outside the array
        // and return that directly using formula
        if (missingCount < k)
            return arr[n - 1] + (k - missingCount);

        // binary search pointers
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            // if missing count at mid is less than k then update l
            if (arr[mid] - (mid + 1) < k) {
                l = mid + 1;
            } else {
                // otherwise update r
                r = mid - 1;
            }
        }

        return l + k;
    }
}