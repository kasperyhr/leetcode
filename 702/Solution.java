class Solution {
    public int search(ArrayReader reader, int target) {
        int high = 1;
        while(reader.get(high) < target)
            high <<= 1;
        int low = high >> 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(reader.get(mid) < target) low = mid + 1;
            else if(reader.get(mid) > target) high = mid - 1;
            else return mid;
        }
        return -1;
    }
}