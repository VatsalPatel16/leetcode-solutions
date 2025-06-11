package Easy;

// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public String makeFancyString(String s) {
        // StringBuilder to store output
        StringBuilder sb = new StringBuilder();
        // append first character from s into sb
        sb.append(s.charAt(0));
        // Initialize count variable
        int count = 1;

        // Iterate over string s
        for (int i = 1; i < s.length(); i++) {
            // if current char is equal to last char of sb then increment count
            if (s.charAt(i) == sb.charAt(sb.length() - 1)) {
                count++;

                // if count is less than 3 then append current char to sb
                if (count < 3) {
                    sb.append(s.charAt(i));
                }
            }
            // if char are not same then set count to 1 and
            // append current char to sb
            else {
                count = 1;
                sb.append(s.charAt(i));
            }
        }

        // return sb as string
        return sb.toString();
    }
}