package Easy;

// Time Complexity: O(d)
// Space Complexity: O(d), where d = number of digits
class Solution {
    public int maximum69Number(int num) {
        // Convert given int num into string
        String s = String.valueOf(num);

        // using method replaceFirst to replace first 6 to 9
        // it will give the maximum number then converting it to int
        return Integer.parseInt(s.replaceFirst("6", "9"));
    }
}