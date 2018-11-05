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
    public boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });
        for(int i = 1; i < intervals.length; i++){
            if(overlap(intervals[i - 1], intervals[i])){
                return false;
            }
        }
        return true;
    }
    
    private boolean overlap(Interval i1, Interval i2){
        return !(i1.end <= i2.start || i2.end <= i1.start);
    }
}