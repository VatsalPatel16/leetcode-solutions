package Medium;

import java.util.Arrays;

// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        // Getting total gas and total cost
        int totalGas = Arrays.stream(gas).sum();
        int totalCost = Arrays.stream(cost).sum();

        // if total gas is less than total cost that means
        // it is impossible to make the trip
        // in that case return -1
        if (totalGas < totalCost) {
            return -1;
        }

        // Two variables currTank to keep track of current tank
        // and startIdx to keep track of from which station to start
        int currTank = 0, startIdx = 0;

        for (int i = 0; i < n; i++) {
            // update currTank
            currTank += gas[i] - cost[i];

            // if value of currTank is less than 0
            if (currTank < 0) {
                // then set startIdx to i + 1
                startIdx = i + 1;
                // and reset currTank
                currTank = 0;
            }
        }

        return startIdx;
    }
}