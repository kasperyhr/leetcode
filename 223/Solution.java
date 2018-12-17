class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area = (C - A) * (D - B) + (G - E) * (H - F);
        int left = Math.max(A, E);
        int right = Math.max(left, Math.min(C, G));
        int down = Math.max(B, F);
        int up = Math.max(down, Math.min(D, H));
        area -= (right - left) * (up - down);
        return area;
    }
}