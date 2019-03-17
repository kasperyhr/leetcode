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
    public Interval[] intervalIntersection(Interval[] A, Interval[] B) {
        int ptr1 = 0;
        int ptr2 = 0;
        List<Interval> ret = new ArrayList();
        while(ptr1 < A.length && ptr2 < B.length){
            if(A[ptr1].start < B[ptr2].start){
                //if A starts first
                if(A[ptr1].end >= B[ptr2].start){
                    ret.add(new Interval(B[ptr2].start, Math.min(A[ptr1].end, B[ptr2].end)));
                    if(A[ptr1].end < B[ptr2].end){
                        ptr1++;
                    } else {
                        ptr2++;
                    }
                } else {
                    ptr1++;
                }
            } else {
                //if B starts first
                if(B[ptr2].end >= A[ptr1].start){
                    ret.add(new Interval(A[ptr1].start, Math.min(B[ptr2].end, A[ptr1].end)));
                    if(B[ptr2].end < A[ptr1].end){
                        ptr2++;
                    } else {
                        ptr1++;
                    }
                } else {
                    ptr2++;
                }
            }
        }
        Interval[] res = new Interval[ret.size()];
        for(int i = 0; i < ret.size(); i++){
            res[i] = ret.get(i);
        }
        return res;
    }
}