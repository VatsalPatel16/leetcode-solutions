package Easy;

// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public String reverseWords(String s) {
        // Storing each string separated by space in strArr
        String strArr[] = s.split(" ");
        // res to store output
        StringBuilder res = new StringBuilder();

        // Iterate over each individual string and reverse it
        // then append it to res
        for (String str : strArr) {
            res.append(reverse(str) + " ");
        }
        // after iteration deleting last space added in the loop
        res.deleteCharAt(res.length() - 1);

        // return res as string
        return res.toString();
    }

    // reverse function to reverse each str using two pointers method
    private String reverse(String str) {
        char[] arr = str.toCharArray();
        int l = 0, r = arr.length - 1;

        while (l < r) {
            char temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }

        return new String(arr);
    }
}