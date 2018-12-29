class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> v = new Stack<Integer>();
        int sum = 0;
        int prev = 0;
        for(String s: ops){
            if(s.equals("+")){
                int v1 = v.pop();
                prev = v.peek() + v1;
                v.push(v1);
                v.push(prev);
            } else if (s.equals("D")){
                prev = v.peek() * 2;
                v.push(prev);
            } else if (s.equals("C")){
                prev = 0 - v.pop();
            } else {
                prev = Integer.parseInt(s);
                v.push(prev);
            }
            sum += prev;
        }
        return sum;
    }
}
