package Medium;

// Time Complexity: O(n)
// Space Complexity: O(n)
class Solution {
    public long calculateScore(String[] instructions, int[] values) {
        int n = values.length;
        // variable score to keep track of final score
        long score = 0;
        // variable i for iteration
        int i = 0;
        // visited array to keep track of already visited instructions
        boolean[] visited = new boolean[n];

        // while i is not out of bound do so
        while (i >= 0 && i < n) {
            // if found that instruction is already visited then break out the loop
            if (visited[i] == true) {
                break;
            }

            // marking current instruction visited
            visited[i] = true;
            // if instruction is "add" then add value[i] in score
            // and increment i
            if (instructions[i].equals("add")) {
                score += values[i];
                i++;
            }
            // if instruction is "jump" then move to (i + values[i])
            else if (instructions[i].equals("jump")) {
                i += values[i];
                // early exit if found i out of bound
                if (i < 0 || i >= n)
                    break;
            }
        }

        return score;
    }
}