class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> s = new Stack();
        s.push(-1);
        int maxArea = 0;
        for(int i = 0; i < heights.length; i++){
            while(s.peek() != -1 && heights[s.peek()] > heights[i]){
                maxArea = Math.max(maxArea, heights[s.pop()] * (i - s.peek() - 1));
            }
            s.push(i);
        }
        int i = heights.length;
        while(s.peek() != -1){
            maxArea = Math.max(maxArea, heights[s.pop()] * (i - s.peek() - 1));
        }
        return maxArea;
    }
}