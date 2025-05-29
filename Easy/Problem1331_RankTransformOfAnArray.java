package Easy;

import java.util.*;

// Time Complexity: O(n log n), due to sorting
// Space Complexity: O(n), where n is the number of elements in the array
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        // cloning arr into temp array
        int[] temp = arr.clone();
        // Sorting the temp array for further use
        Arrays.sort(temp);
        // map to store value and its rank
        Map<Integer, Integer> map = new HashMap<>();
        // variable rank starts with 1
        int rank = 1;

        // Loop to store value and its rank in the map
        for (int i = 0; i < temp.length; i++) {
            // if map doesn't contain key temp[i] then put it in map
            // and increment rank
            if (!map.containsKey(temp[i])) {
                map.put(temp[i], rank);
                rank++;
            }
        }

        // Finally replace each value of arr with its rank
        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }

        return arr;
    }
}