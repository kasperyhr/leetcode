class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for(int i = 0; i < gas.length; i++){
            int j = next(gas, cost, i);
            if(j == -1)
                return i;
            if(j <= i)
                return -1;
            i = j - 1;
        }
        return -1;
    }
    
    private int next(int[] gas, int[] cost, int i){
        int j = i;
        int val = 0;
        val += gas[j] - cost[j];
        j = j + 1 == gas.length ? 0 : j + 1;
        if(val < 0)
            return j;
        while(j != i){
            val += gas[j] - cost[j];
            j = j + 1 == gas.length ? 0 : j + 1;
            if(val < 0)
                return j;
        }
        return -1;
    }
}