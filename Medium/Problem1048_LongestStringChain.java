package Medium;

import java.util.*;

// Time Complexity: O(n log n + n * m^2)
// Space Complexity: O(n * m)
// where, n is the number of words and m is the maximum word length
class Solution {
    public int longestStrChain(String[] words) {
        // dp of HashMap
        HashMap<String, Integer> dp = new HashMap<>();
        // res to store output
        int res = 1;

        // sorting words array by length
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        // Iterate over given array words
        for (String word : words) {
            // Initialize chain length of each word
            dp.put(word, 1);

            // try removing each char from word to find predecessor
            for (int i = 0; i < word.length(); i++) {
                String pred = word.substring(0, i) + word.substring(i + 1);

                if (dp.containsKey(pred)) {
                    dp.put(word, Math.max(dp.get(word), dp.get(pred) + 1));
                }
            }

            // maximize the res
            res = Math.max(res, dp.get(word));
        }

        return res;
    }
}