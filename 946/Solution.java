class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> s = new Stack<Integer>();
        int ptr = 0;
        for(int i = 0; i < pushed.length; i++){
            s.push(pushed[i]);
            while(!s.isEmpty() && s.peek() == popped[ptr]){
                s.pop();
                ptr++;
            }
        }
        if(s.isEmpty())
            return true;
        return false;
    }
}