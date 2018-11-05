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
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length == 0)
            return 0;
        Arrays.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval i1, Interval i2){
                return i1.start - i2.start;
            }
        });
        List<Interval> l = new LinkedList<Interval>();
        l.add(intervals[0]);
        int ret = 1;
        for(int i = 1; i < intervals.length; i++){
            l.add(intervals[i]);
            for(int j = 0; j < l.size(); j++){
                while(!overlap(l.get(j), intervals[i])){
                    l.remove(j);
                }
            }
            ret = Math.max(ret, l.size());
        }
        return ret;
    }
    
    private boolean overlap(Interval i1, Interval i2){
        return !(i1.end <= i2.start || i2.end <= i1.start);
    }
}