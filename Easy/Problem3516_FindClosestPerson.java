package Easy;

// Time Complexity: O(1)
// Space Complexity: O(1)
class Solution {
    public int findClosest(int x, int y, int z) {
        // Fiding distance between person1(x) and person3(z)
        int dist1 = Math.abs(x - z);
        // Fiding distance between person2(y) and person3(z)
        int dist2 = Math.abs(y - z);

        // if both distances are same then return 0
        // otherwise check if dist1 is less than dist2 if yes
        // then return 1 otherwise return 2
        return (dist1 == dist2) ? 0 : ((dist1 < dist2) ? 1 : 2);
    }
}