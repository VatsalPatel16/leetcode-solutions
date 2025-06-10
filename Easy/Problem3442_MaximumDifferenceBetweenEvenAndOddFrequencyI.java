package Easy;

import java.util.HashMap;
import java.util.Map;

// Time Complexity: O(n)
// Space Complexity: O(1), the input consists of only lowercase letters, the size of the map is bounded by 26 - a constant
class Solution {
    public int maxDifference(String s) {
        // HashMap to store char and its frequency from the string
        Map<Character, Integer> freq = new HashMap<>();

        // Iterate over string and put char and its freq in the map
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // Initialize maxOddFreq and minEvenFreq variables
        int maxOddFreq = 0, minEvenFreq = Integer.MAX_VALUE;

        // Iterate over each values in the map
        for (int val : freq.values()) {
            // if value is even then update minEvenFreq
            if ((val % 2) == 0) {
                minEvenFreq = Math.min(minEvenFreq, val);
            }
            // otherwise value is odd and update maxOddFreq
            else {
                maxOddFreq = Math.max(maxOddFreq, val);
            }
        }

        // return the difference of maxOddFreq and minEvenFreq
        return maxOddFreq - minEvenFreq;
    }
}