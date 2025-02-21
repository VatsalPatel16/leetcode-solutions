package Easy;

// Time Complexity: O(n)
// Space Complexity: O(n) due to creation of new string
class Solution {
    public boolean isPalindrome(String s) {
        // regex to remove all non-alphanumeric characters from the string s
        String regex = "[^a-zA-Z0-9]";
        // also convert it into lower case
        s = s.replaceAll(regex, "").toLowerCase();
        // Two pointers left and right
        int left = 0, right = s.length() - 1;

        // while both pointers don't cross each other do so
        while (left < right) {
            // if charAt left is not equal to charAt right
            // return false (that means given string is not palindrome)
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            } else {
                // if equal then increment left pointer and
                // decrement right pointer
                left++;
                right--;
            }
        }

        // return true if string is palindrome
        return true;
    }
}