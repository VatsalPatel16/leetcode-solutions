package Easy;

import java.util.*;

// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public String reverseVowels(String s) {
        // Converting given string s to char array
        char[] arr = s.toCharArray();
        // set of vowels to check for the vowels in the loop, O(1) lookup
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        // two pointers l & r
        int l = 0, r = arr.length - 1;

        // while both pointer don't cross each other do so
        while (l < r) {
            // increment l pointer until we get any vowel
            while (!vowels.contains(arr[l]) && l < r) {
                l++;
            }
            // same decrement r pointer until we get any vowel
            while (!vowels.contains(arr[r]) && l < r) {
                r--;
            }
            // now swap them and increment l pointer and decrement r pointer
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }

        // after the loop vowels will be reversed and make string of that to get output
        return new String(arr);
    }
}