package Easy;

import java.util.HashMap;

// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {

    public int romanToInt(String s) {
        // Storing symbol and its value in the hashmap
        HashMap<Character, Integer> val = new HashMap<>();
        val.put('I', 1);
        val.put('V', 5);
        val.put('X', 10);
        val.put('L', 50);
        val.put('C', 100);
        val.put('D', 500);
        val.put('M', 1000);

        int n = s.length(), sum = 0;
        // Iterate over given String s
        for (int i = 0; i < n; i++) {
            // if (current_index + 1) is less than n
            // and value of current symbol is less than value of next symbol
            if ((i + 1) < n && val.get(s.charAt(i)) < val.get(s.charAt(i + 1))) {
                // then subtract value of current symbol from sum
                sum -= val.get(s.charAt(i));
            } else {
                // otherwise add value of current symbol in sum
                sum += val.get(s.charAt(i));
            }
        }
        return sum;
    }
}