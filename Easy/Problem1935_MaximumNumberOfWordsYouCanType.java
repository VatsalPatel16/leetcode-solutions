package Easy;

import java.util.HashSet;
import java.util.Set;

// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        // set to store broken letters
        Set<Character> set = new HashSet<>();
        // res to store output
        int res = 0;
        // flag isValid to check if any word contains broken letters or not
        boolean isValid = true;

        // building set from string brokenLetters
        for (char c : brokenLetters.toCharArray()) {
            set.add(c);
        }

        // iterate over given string text
        for (int i = 0; i < text.length(); i++) {
            // get the current char
            char c = text.charAt(i);

            // if current char is space then check if word is valid
            // yes then increment res and reset the isValid flag
            if (c == ' ') {
                if (isValid) {
                    res++;
                }
                isValid = true;
            }
            // otherwise check if set contains current char
            // yes then set isValid false because that will be broken letter
            else {
                if (set.contains(c)) {
                    isValid = false;
                }
            }

        }

        // at last also check for last word
        if (isValid) {
            res++;
        }

        return res;
    }
}