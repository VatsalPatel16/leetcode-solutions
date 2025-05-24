package Easy;

import java.util.ArrayList;
import java.util.List;

// Time Complexity: O(n * L), where n = number of words and L = average word length
// Space Complexity: O(1) (excluding output)
class Solution {
    public List<Integer> findWordsContaining(String[] words, char x) {
        // res list to store output
        List<Integer> res = new ArrayList<>();

        // Iterate over words array
        for (int i = 0; i < words.length; i++) {
            // if index of char x is not equal to -1
            // that means x is present in current word
            // add current word's index in res list
            if (words[i].indexOf(x) != -1) {
                res.add(i);
            }
        }

        return res;
    }
}