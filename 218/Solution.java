class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        return sky(buildings, 0, buildings.length);
    }
    
    private List<int[]> sky(int[][] buildings, int start, int end){
        List<int[]> ret = new ArrayList();
        if(start == end)
            return ret;
        if(end == start + 1){
            int[] b = buildings[start];
            int[] b1 = {b[0], b[2]};
            int[] b2 = {b[1], 0};
            ret.add(b1);
            ret.add(b2);
            return ret;
        }
        int mid = (start + end) / 2;
        List<int[]> l1 = sky(buildings, start, mid);
        List<int[]> l2 = sky(buildings, mid, end);
        merge(l1, l2, ret);
        return ret;
    }
    
    private void merge(List<int[]> l1, List<int[]> l2, List<int[]> ret){
        int currHeight = 0;
        int heightFrom = 0;
        int l1Height = 0;
        int l2Height = 0;
        int l1Index = 0;
        int l2Index = 0;
        while(l1Index != l1.size() || l2Index != l2.size()){
            if(l1Index == l1.size()){
                heightFrom = 2;
                currHeight = l2Height = l2.get(l2Index)[1];
                if(ret.size() > 0 && ret.get(ret.size() - 1)[0] == l2.get(l2Index)[0])
                    ret.remove(ret.size() - 1);
                ret.add(l2.get(l2Index++));
            } else if(l2Index == l2.size()){
                heightFrom = 1;
                currHeight = l1Height = l1.get(l1Index)[1];
                if(ret.size() > 0 && ret.get(ret.size() - 1)[0] == l1.get(l1Index)[0])
                    ret.remove(ret.size() - 1);
                ret.add(l1.get(l1Index++));
            } else {
                int[] l1E = l1.get(l1Index);
                int[] l2E = l2.get(l2Index);
                if(l1E[0] < l2E[0] || (l1E[0] == l2E[0] && l1E[1] > l2E[1])){
                    l1Height = l1E[1];
                    l1Index++;
                    if(l1Height > currHeight || (heightFrom == 1 && l1Height >= l2Height)){
                        heightFrom = 1;
                        currHeight = l1Height;
                        if(ret.size() > 0 && ret.get(ret.size() - 1)[0] == l1E[0])
                            ret.remove(ret.size() - 1);
                        ret.add(l1E);
                    } else if(l1Height < l2Height && l2Height < currHeight && heightFrom == 1) {
                        heightFrom = 2;
                        currHeight = l2Height;
                        int[] add = {l1E[0], l2Height};
                        if(ret.size() > 0 && ret.get(ret.size() - 1)[0] == l1E[0])
                            ret.remove(ret.size() - 1);
                        ret.add(add);
                    } else {
                        heightFrom = 2;
                    }
                } else {
                    l2Height = l2E[1];
                    l2Index++;
                    if(l2Height > currHeight || (heightFrom == 2 && l2Height >= l1Height)){
                        heightFrom = 2;
                        currHeight = l2Height;
                        if(ret.size() > 0 && ret.get(ret.size() - 1)[0] == l2E[0])
                            ret.remove(ret.size() - 1);
                        ret.add(l2E);
                    } else if(l2Height < l1Height && l1Height < currHeight && heightFrom == 2) {
                        heightFrom = 1;
                        currHeight = l1Height;
                        int[] add = {l2E[0], l1Height};
                        if(ret.size() > 0 && ret.get(ret.size() - 1)[0] == l2E[0])
                            ret.remove(ret.size() - 1);
                        ret.add(add);
                    } else {
                        heightFrom = 1;
                    }
                }
            }
        }
    }
}