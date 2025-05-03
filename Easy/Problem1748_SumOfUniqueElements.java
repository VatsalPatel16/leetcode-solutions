package Easy;

import java.util.HashMap;
import java.util.Map;

// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public int sumOfUnique(int[] nums) {
        // Map to store element from nums array and its frequency
        Map<Integer, Integer> map = new HashMap<>();

        // Getting element and its frequency in the map
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // res to store output
        int res = 0;
        // Iterate over map
        for (Map.Entry<Integer, Integer> i : map.entrySet()) {
            // if value of any key is one that means it is a unique element
            // add key in res
            if (i.getValue() == 1) {
                res += i.getKey();
            }
        }

        return res;
    }
}