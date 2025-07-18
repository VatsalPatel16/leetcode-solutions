package Easy;

// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public String reverseOnlyLetters(String s) {
        // converting given string s into char array
        char[] arr = s.toCharArray();
        // two pointers l & r
        int l = 0, r = arr.length - 1;

        // while both pointer don't cross each other do so
        while (l < r) {
            // while char at l pointer is not letter then
            // increment l pointer
            while (l < r && !Character.isLetter(arr[l])) {
                l++;
            }
            // same while char at r pointer is not letter then
            // decrement r pointer
            while (l < r && !Character.isLetter(arr[r])) {
                r--;
            }
            // then swap then letters and increment l pointer and decrement r pointer
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
        // at last return arr as string
        return new String(arr);
    }
}