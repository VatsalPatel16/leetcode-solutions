package Easy;

import java.util.*;

// Time Complexity: O(n + b), where O(n) for replaceAll, toLowerCase and split("\\s+") & O(b) for building bannedSet
// Space Complexity: O(m + b), where O(m) for HashMap and O(b) for bannedSet
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        // map to store word and its count
        Map<String, Integer> map = new HashMap<>();
        // making set of banned words for O(1) lookup
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        // string ans to store output
        String ans = "";
        // maxFreq to store maximum frequency of word
        int maxFreq = 0;
        // replacing punctuation with space and convert it to lowercase
        paragraph = paragraph.replaceAll("[^a-zA-Z]", " ").toLowerCase();

        // now split each word by space
        for (String s : paragraph.split("\\s+")) {
            // and if s is not banned word then add it in map
            if (!bannedSet.contains(s)) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }

        // now finding word with max frequency
        for (String s : map.keySet()) {
            if (map.get(s) > maxFreq) {
                ans = s;
                maxFreq = map.get(s);
            }
        }

        return ans;
    }
}