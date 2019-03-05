class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> m = new HashMap<String, Integer>(); 
        for(int i = 0; i < list1.length; i++){
            m.put(list1[i], i);
        }
        int val = Integer.MAX_VALUE;
        List<String> ret = new ArrayList<String>();
        for(int i = 0; i < list2.length; i++){
            if(m.containsKey(list2[i]) && val > i + m.get(list2[i])){
                val = i + m.get(list2[i]);
                ret = new ArrayList<String>();
                ret.add(list2[i]);
            } else if(m.containsKey(list2[i]) && val == i + m.get(list2[i])){
                ret.add(list2[i]);
            }
        }
        return ret.toArray(new String[0]);
    }
}