package Easy;

import java.util.ArrayList;

// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();

        // resList to store output and then convert it to string array
        ArrayList<String> resList = new ArrayList<>();

        // Iterate over given string s
        for (int i = 0; i < s.length(); i += k) {
            // check if (i + k) is in bound if yes then
            // add substring from (i, i + k) in resList
            if ((i + k) < n)
                resList.add(s.substring(i, i + k));
            else {
                // otherwise make StringBuilder from last substring
                // and append the fill char to that
                StringBuilder temp = new StringBuilder(s.substring(i));
                int remaining = k - temp.length();

                for (int j = 0; j < remaining; j++) {
                    temp.append(fill);
                }

                // and add that string to resList
                resList.add(temp.toString());
            }
        }

        // Convert resList into res array
        String[] res = resList.toArray(new String[0]);

        return res;
    }
}