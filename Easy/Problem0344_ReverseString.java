package Easy;

// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public void reverseString(char[] s) {
        // left(at start) and right(at the end of array) pointer
        int l = 0, r = s.length - 1;
        // while both pointer don't cross each other do swapping and increment pointers
        while (l < r) {
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }
}