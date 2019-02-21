class Solution {
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> ret = new HashSet<Integer>();
        for(int i = 0; i <= 18 && Math.pow(x, i) <= bound; i++){
            for(int j = 0; j <= 18 && Math.pow(x, i) + Math.pow(y, j) <= bound; j++){
                int val = (int)(Math.pow(x, i) + Math.pow(y, j));
                ret.add(val);
            }
        }
        return new ArrayList<Integer>(ret);
    }
}