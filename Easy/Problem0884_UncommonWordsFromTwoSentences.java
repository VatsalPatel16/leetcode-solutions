package Easy;

import java.util.HashMap;

// Time Complexity: O(n + m + w), where n = number of words in s1, m = number of words in s2
// & w = total number of unique words in both strings
// Space Complexity: O(w)
class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        // map to store word and its count from both Strings
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        // Storing word and its count in the map from s1
        for (String s : s1.split(" ")) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        // Storing word and its count in the map from s2
        for (String s : s2.split(" ")) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        int count = 0;
        // Iterate over map and if any word's count is 1
        // then increment count variable
        for (int i : map.values()) {
            if (i == 1) {
                count++;
            }
        }

        // res variable to store output
        String[] res = new String[count];

        int k = 0;
        // store word with count 1 in the res array
        for (String s : map.keySet()) {
            if (map.get(s) == 1) {
                res[k] = s;
                k++;
            }
        }

        return res;
    }
}