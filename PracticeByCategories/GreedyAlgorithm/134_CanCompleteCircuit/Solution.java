class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int startPos = 0;
        int gasStorage = 0;
        int gasConsume = 0;
        for (int i = 0; i < gas.length; i++) {
            gasStorage += gas[i] - cost[i];
            if (gasStorage < 0) {
                gasConsume += gasStorage;
                gasStorage = 0;
                startPos = i + 1;
            }
        }
        if (gasStorage + gasConsume >= 0) {
            return startPos;
        }
        return -1;
    }
}