package Easy;

// Time Complexity: O(m + n), where m = length of magazine, n = length of ransomNote
// Space Complexity: O(1) (constant space, because array size is fixed at 26)
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // freq array to store frequency of each char from magazine
        int[] freq = new int[26];

        // get the each char from magazine and update freq array
        for (char c : magazine.toCharArray()) {
            freq[c - 'a']++;
        }

        // now checking if ransomNote can be constructed using
        // the letters from magazine
        for (char c : ransomNote.toCharArray()) {
            // if freq of any char becomes negative
            // at that time return false
            // ransomNote can't be constructed using magazine
            if (--freq[c - 'a'] < 0) {
                return false;
            }
        }

        // if successful pass then return true
        // ransomNote can be constructed using magazine
        return true;
    }
}