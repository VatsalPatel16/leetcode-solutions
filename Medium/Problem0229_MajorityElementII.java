package Medium;

import java.util.ArrayList;
import java.util.List;

// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        // Using Boyer-Moore Voting Algorithm
        // Two variables to store possible candidates
        Integer candidate1 = null, candidate2 = null;
        // and other two to keep track of its count in the nums array
        int cnt1 = 0, cnt2 = 0;
        // res list to store output
        List<Integer> res = new ArrayList<>();

        // Iterate over nums array
        // first loop to get possible candidates from nums array
        for (int n : nums) {
            // if cnt1 is equal to 0 and candidate2 is equal to null
            // or n is not equal to candidate2 then
            // set candidate1 as n and cnt1 as 1
            if (cnt1 == 0 && (candidate2 == null || n != candidate2)) {
                candidate1 = n;
                cnt1 = 1;
            }
            // else if cnt2 is equal to 0 and candidate1 is equal to null
            // or n is not equal to candidate1 then
            // set candidate2 as n and cnt2 as 1
            else if (cnt2 == 0 && (candidate1 == null || n != candidate1)) {
                candidate2 = n;
                cnt2 = 1;
            }
            // else if n is equal to candidate1 then increment cnt1
            else if (n == candidate1) {
                cnt1++;
            }
            // else if n is equal to candidate2 then increment cnt2
            else if (n == candidate2) {
                cnt2++;
            }
            // otherwise decrement both cnt1 and cnt2
            else {
                cnt1--;
                cnt2--;
            }
        }

        cnt1 = 0;
        cnt2 = 0;
        // second loop to check if candidates appear more then ⌊ n/3 ⌋ times
        for (int n : nums) {
            if (n == candidate1)
                cnt1++;
            else if (n == candidate2)
                cnt2++;
        }

        int threshold = nums.length / 3;
        // if cnt1 is greater than threshold then add candidate1 in res
        if (cnt1 > threshold)
            res.add(candidate1);

        // if cnt2 is greater than threshold then add candidate2 in res
        if (cnt2 > threshold)
            res.add(candidate2);

        return res;
    }
}