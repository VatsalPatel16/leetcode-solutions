package Easy;

// Time Complexity: O(1)
// Space Complexity: O(1)
class Solution {
    public int differenceOfSums(int n, int m) {
        // The sum of the first n natural numbers
        int total = (n * (n + 1)) / 2;

        // how many numbers between 1 and n are divisible by m
        int k = n / m;

        // This will give sum of all numbers between 1 to n
        // which are divisible by m
        int divisibleSum = m * ((k * (k + 1)) / 2);

        // So, num1 - num2 = (total - divisibleSum) - divisibleSum
        // which is equal to total - (2 * divisibleSum)
        return total - (2 * divisibleSum);
    }
}