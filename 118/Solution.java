class Solution {
    public List<List<Integer>> generate(int numRows) {
        ArrayList<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(numRows == 0)
            return ret;
        ArrayList<Integer> a = new ArrayList<Integer>();
        a.add(1);
        ret.add(a);
        for(int i = 1; i < numRows; i++){
            List<Integer> b = ret.get(ret.size() - 1);
            ArrayList<Integer> c = new ArrayList<Integer>();
            c.add(1);
            for(int j = 0; j < b.size() - 1; j++){
                c.add(b.get(j) + b.get(j + 1));
            }
            c.add(1);
            ret.add(c);
        }
        return ret;
    }
}