package Easy;

import java.util.*;

// Time Complexity: O(n)
// Space Complexity: O(1), the size of vowel set is fixed and doesn't change on given input size
class Solution {
    public boolean isValid(String word) {
        // if length of given string word is less than 3 then return false
        // it is not valid
        if (word.length() < 3) {
            return false;
        }

        // using vowel set to check for vowels in word
        Set<Character> vowel = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        // Two flags to check if vowel and consonant available in the word
        boolean hasVowel = false, hasConsonant = false;

        // Iterate over word string
        for (char c : word.toCharArray()) {
            // if invalid char found then return false
            if (!Character.isLetterOrDigit(c)) {
                return false;
            }
            // if current c is vowel then mark hasVowel flag as true
            else if (vowel.contains(c)) {
                hasVowel = true;
            }
            // if current c is letter and not vowel that means it is consonant
            // mark hasConsonant flag as true
            else if (Character.isLetter(c) && !vowel.contains(c)) {
                hasConsonant = true;
            }
        }

        // if both vowel and consonant available then return true
        // if not then this will return false
        return hasVowel && hasConsonant;
    }
}