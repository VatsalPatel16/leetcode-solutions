package Easy;

// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public boolean isCircularSentence(String sentence) {
        // Checking if first and last char are same or not
        if (sentence.charAt(0) != sentence.charAt(sentence.length() - 1)) {
            // if not same then return false
            return false;
        }

        // indexOf method will return -1 if that char never occurs
        // Getting index of first space
        int index = sentence.indexOf(" ");

        // if index is -1 then return true
        // Only one word in the sentence and first and last char are same
        if (index == -1)
            return true;

        // Iterate while index is not equal to -1
        while (index != -1) {
            // If char before and after space are not same then return false
            if (sentence.charAt(index - 1) != sentence.charAt(index + 1))
                return false;

            // Otherwise update index to next space
            index = sentence.indexOf(" ", index + 1);
        }

        return true;
    }
}