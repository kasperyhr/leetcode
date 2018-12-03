class Solution {
    public String largestTimeFromDigits(int[] A) {
        Arrays.sort(A);
        ArrayList<ArrayList<Integer>> l = permute(A);
        Collections.sort(l, new Comparator<ArrayList<Integer>>(){
            @Override
            public int compare(ArrayList<Integer> l1, ArrayList<Integer> l2){
                for(int i = 0; i < l1.size(); i++){
                    if(l1.get(i) != l2.get(i))
                        return l2.get(i) - l1.get(i);
                }
                return 0;
            }
        });
        for(ArrayList<Integer> ll: l){
            int hour = ll.get(0)*10 + ll.get(1);
            int min = ll.get(2)*10 + ll.get(3);
            if(hour >= 0 && hour <= 23 && min >= 0 && min <= 59){
                return "" + ll.get(0) + ll.get(1) + ":" + ll.get(2) + ll.get(3);
            }
        }
        return "";
    }
    
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        //start from an empty list
        result.add(new ArrayList<Integer>());

        for (int i = 0; i < num.length; i++) {
            //list of list in current iteration of the array num
            ArrayList<ArrayList<Integer>> current = new ArrayList<ArrayList<Integer>>();

            for (ArrayList<Integer> l : result) {
                // # of locations to insert is largest index + 1
                for (int j = 0; j < l.size()+1; j++) {
                    // + add num[i] to different locations
                    l.add(j, num[i]);

                    ArrayList<Integer> temp = new ArrayList<Integer>(l);
                    current.add(temp);

                    //System.out.println(temp);

                    // - remove num[i] add
                    l.remove(j);
                }
            }

            result = new ArrayList<ArrayList<Integer>>(current);
        }

        return result;
    }
}