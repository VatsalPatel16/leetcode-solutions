package Medium;

// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public String reverseWords(String s) {
        // replace whitespaces with one whitespace and trim both ends
        s = s.replaceAll("\\s+", " ").trim();
        // Then splitting String into String array
        String[] strArray = s.split(" ");

        // Two pointers l & r
        int l = 0, r = strArray.length - 1;

        // while both pointers don't cross each other swap Strings
        while (l < r) {
            String temp = strArray[l];
            strArray[l] = strArray[r];
            strArray[r] = temp;
            l++;
            r--;
        }

        // Then join String array using one space
        return String.join(" ", strArray);
    }
}