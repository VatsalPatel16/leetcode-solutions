package Easy;

// Time Complexity: O(1)
// Space Complexity: O(1)
class Solution {
    public int findComplement(int num) {
        int x = num;

        // Build a mask with all bits set to 1 up to the most significant bit of num
        // Understaing it with example
        // x = 19 (10011 in binary)
        x |= (x >> 1); // -> 10011 | 01001 = 11011
        x |= (x >> 2); // -> 11011 | 00110 = 11111
        x |= (x >> 4); // -> 11111 | 00001 = 11111
        x |= (x >> 8); // continue
        x |= (x >> 16); // At last 16 bits to cover 32-bit integers

        // XOR the original number with the mask to flip only the significant bits
        // because 1 ^ 1 = 0, 1 ^ 0 = 1
        // example 10011 ^ 11111 = 01100
        return num ^ x;
    }
}