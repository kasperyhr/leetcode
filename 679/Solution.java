class Solution {
    public boolean judgePoint24(int[] nums) {
        double[] d = new double[4];
        List<Double> l = new LinkedList<Double>();
        for(int i = 0; i < 4; i++){
            l.add(nums[i] * 1.0);
        }
        return solve(l);
    }
    
    private boolean solve(List<Double> l){
        boolean ret = false;
        if(l.size() == 1){
            return Math.abs(l.get(0) - 24.0) < 1e-6;
        } else {
            for(int i = 0; i < l.size(); i++){
                for(int j = 0; j < l.size(); j++){
                    if(j == i)
                        continue;
                    List<Double> next = new LinkedList<Double>();
                    for(int ptr = 0; ptr < l.size(); ptr++){
                        if(ptr == i || ptr == j)
                            continue;
                        next.add(l.get(ptr));
                    }
                    List<Double> next1 = new LinkedList<Double>(next);
                    List<Double> next2 = new LinkedList<Double>(next);
                    List<Double> next3 = new LinkedList<Double>(next);
                    List<Double> next4 = new LinkedList<Double>(next);
                    next1.add(l.get(i) + l.get(j));
                    next2.add(l.get(i) - l.get(j));
                    next3.add(l.get(i) * l.get(j));
                    if(l.get(j) != 0)
                        next4.add(l.get(i) / l.get(j));
                    ret = solve(next1) || solve(next2) || solve(next3);
                    if(l.get(j) != 0)
                        ret = ret || solve(next4);
                    if(ret)
                        return true;
                }
            }
        }
        return false;
    }
}