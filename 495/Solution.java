class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if(timeSeries.length == 0 || duration == 0)
            return 0;
        int prev = timeSeries[0];
        int ret = 0;
        for(int i = 1; i < timeSeries.length; i++){
            ret += Math.min(timeSeries[i] - prev, duration);
            prev = timeSeries[i];
        }
        ret += duration;
        return ret;
    }
}