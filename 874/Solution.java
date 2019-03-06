class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int d = 0;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        // turn right +1, turn left -1
        Set<Long> s = new HashSet<Long>();
        for(int[] ob: obstacles){
            long xx = (long) ob[0] + 30000;
            long yy = (long) ob[1] + 30000;
            s.add((xx << 16) + yy);
        }
        
        int x = 0;
        int y = 0;
        int ret = 0;
        for(int com: commands){
            if(com == -1){
                d += 1;
                d %= 4;
            } else if(com == -2){
                d += 3;
                d %= 4;
            } else {
                int val = com;
                while(val > 0){
                    long xx = (long) x + dx[d] + 30000;
                    long yy = (long) y + dy[d] + 30000;
                    if(s.contains((xx << 16) + yy)) break;
                    x += dx[d];
                    y += dy[d];
                    val --;
                    ret = Math.max(ret, x*x+y*y);
                }
            }
        }
        return ret;
    }
}