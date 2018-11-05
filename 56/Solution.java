/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size() <= 1)
            return intervals;
        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });
        Interval prev = intervals.get(0);
        List<Interval> ret = new LinkedList<Interval>();
        for(int i = 1; i < intervals.size(); i++){
            if(overlap(prev, intervals.get(i))){
                prev = merge(prev, intervals.get(i));
            } else {
                ret.add(prev);
                prev = intervals.get(i);
            }
        }
        ret.add(prev);
        return ret;
    }
    
    private Interval merge(Interval i1, Interval i2){
        return new Interval(Math.min(i1.start, i2.start), Math.max(i1.end, i2.end));
    }
    
    private boolean overlap(Interval i1, Interval i2){
        return i1.start <= i2.end && i2.start <= i1.end;
    }
}