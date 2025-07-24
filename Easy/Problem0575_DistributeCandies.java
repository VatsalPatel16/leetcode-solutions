package Easy;

import java.util.HashSet;
import java.util.Set;

// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public int distributeCandies(int[] candyType) {
        int n = candyType.length;
        // set to store unique candy type from candyType array
        Set<Integer> uniqueCandyType = new HashSet<>();

        // adding each candyType in set
        for (int c : candyType) {
            uniqueCandyType.add(c);
        }

        // if size of set is greater than or equal to (n / 2)
        // then Alice can eat (n / 2) different types of candies
        if (uniqueCandyType.size() >= (n / 2)) {
            return (n / 2);
        }

        // otherwise she can only eat unique candy type given
        // in the candyType array not (n / 2) different types of candies
        return uniqueCandyType.size();
    }
}