class Solution {
    public String predictPartyVictory(String senate) {
        LinkedList<Integer> q = new LinkedList<Integer>();
        int[] mem = new int[]{0, 0};
        int[] ban = new int[]{0, 0};
        //R = 0, D = 1
        for(char c: senate.toCharArray()){
            int i = (c == 'R') ? 0 : 1;
            mem[i]++;
            q.addLast(i);
        }
        while(mem[0] > 0 && mem[1] > 0){
            int v = q.removeFirst();
            if(ban[v] > 0){
                ban[v]--;
                mem[v]--;
            } else {
                ban[v^1]++;
                q.addLast(v);
            }
        }
        int v = q.removeFirst();
        return (v == 0) ? "Radiant" : "Dire";
    }
}