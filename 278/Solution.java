/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int low = 1;
        int high = n;
        while(low < high){
            int mid = low / 2 + high / 2;
            if(isBadVersion(mid)){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if(isBadVersion(low))
            return low;
        else
            return low + 1;
    }
}