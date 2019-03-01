class Solution {
    public static final char ADD = '+';
    public static final char SUB = '-';
    public static final char MUL = '*';
    public List<Integer> diffWaysToCompute(String input) {
        // System.out.println(input);
        List<Integer> ret = new ArrayList<Integer>();
        if(input.indexOf(ADD) < 0 && input.indexOf(SUB) < 0 && input.indexOf(MUL) < 0){
            ret.add(Integer.parseInt(input));
            return ret;
        }
        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            switch(c){
                case ADD:
                case SUB:
                case MUL:
                    List<Integer> l1 = diffWaysToCompute(input.substring(0, i));
                    List<Integer> l2 = diffWaysToCompute(input.substring(i+1));
                    for(int i1: l1){
                        for(int i2: l2){
                            switch(c){
                                case ADD:
                                    ret.add(i1 + i2);
                                    break;
                                case SUB:
                                    ret.add(i1 - i2);
                                    break;
                                case MUL:
                                    ret.add(i1 * i2);
                                    break;
                            }
                        }
                    }
            }
        }
        return ret;
    }
}