class Solution {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        long left = Math.max(rec1[0], rec2[0]);
        long right = Math.max(left, Math.min(rec1[2], rec2[2]));
        long down = Math.max(rec1[1], rec2[1]);
        long up = Math.max(down, Math.min(rec1[3], rec2[3]));
        double area = (right - left) * (up - down);
        return area > 0;
    }
}