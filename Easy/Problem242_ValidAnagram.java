package Easy;

// Time Complexity : O(n)
// Space Complexity : O(1) only array of size 26 is used
class Problem242_ValidAnagram {
    public boolean isAnagram(String s, String t) {
        // if length of string s is not equal to length of string t
        // return false
        if (s.length() != t.length())
            return false;

        // Creating array of size 26
        int[] arr = new int[26];

        // update arr according to each char in string s and t
        // [s.charAt(i) - 'a'] will be converted into index of arr from 0 to 25
        // same for [t.charAt(i) - 'a']
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }

        // if string t is an anagram of s then arr will only contain 0 at each index
        // if found value other than 0 that means string t is not anagram of string s
        for (int i : arr) {
            if (i != 0)
                return false;
        }

        // if anagram then return true
        return true;
    }
}
