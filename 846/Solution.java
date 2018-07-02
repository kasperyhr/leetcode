class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        PriorityQueue<Integer> q = new PriorityQueue();
        for(int i: hand){
            q.add(i);
        }
        while(!q.isEmpty()){
            int a = q.poll();
            for(int i = 1; i < W; i++){
                if(!q.remove(a + i))
                    return false;
            }
        }
        return true;
    }
}