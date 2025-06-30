package Easy;

import java.util.HashMap;

// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public int findLHS(int[] nums) {
        // HashMap to store value and its frequency
        HashMap<Integer, Integer> freq = new HashMap<>();

        // Iterate over nums array and get the frequency of each value
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        // maxLen variable to store output
        int maxLen = 0;

        // Iterate over each key in the map
        for (int key : freq.keySet()) {
            // if for current key, if (key + 1) is available in the map
            // then update maxLen
            if (freq.containsKey(key + 1)) {
                maxLen = Math.max(maxLen, freq.get(key) + freq.get(key + 1));
            }
        }

        return maxLen;
    }
}