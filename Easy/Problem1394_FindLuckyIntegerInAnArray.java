package Easy;

import java.util.HashMap;
import java.util.Map;

// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public int findLucky(int[] arr) {
        // freq map to store value and its freq
        Map<Integer, Integer> freq = new HashMap<>();

        // Iterate over array arr
        for (int n : arr) {
            // Putting value and its freq from arr
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        // res to store output
        int res = -1;
        // Iterate over freq map
        for (int key : freq.keySet()) {
            // if key is equal to its freq and value of key is
            // greater than res then update res
            if (key == freq.get(key) && key > res) {
                res = key;
            }
        }

        return res;
    }
}