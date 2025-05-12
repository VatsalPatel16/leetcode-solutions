package Easy;

import java.util.Arrays;

// Time Complexity: O(n + 26) ~O(n)
// Space Complexity: O(26) ~O(1)
class Solution {
    public int firstUniqChar(String s) {
        // Visited array to keep track of each char
        int[] visited = new int[26];
        // Filling array with -1
        Arrays.fill(visited, -1);

        for (int i = 0; i < s.length(); i++) {
            // if char encountered first time then set it to i
            if (visited[s.charAt(i) - 'a'] == -1) {
                visited[s.charAt(i) - 'a'] = i;
            }
            // else we encountered second time then set it to -2
            else {
                visited[s.charAt(i) - 'a'] = -2;
            }
        }

        // After that get the min index from array
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (visited[i] >= 0) {
                res = Math.min(res, visited[i]);
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}