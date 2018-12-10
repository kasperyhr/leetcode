class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1)
            return s;
        StringBuffer[] sbs = new StringBuffer[numRows];
        for(int i = 0; i < numRows; i++){
            sbs[i] = new StringBuffer();
        }
        int ptr = 0;
        boolean reversed = false;
        for(int i = 0; i < s.length(); i++){
            sbs[ptr].append(s.charAt(i));
            if(reversed){
                ptr--;
            } else {
                ptr++;
            }
            if(ptr == numRows){
                ptr = numRows - 2;
                reversed = !reversed;
            } else if(ptr == -1){
                ptr = 1;
                reversed = !reversed;
            }
        }
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < numRows; i++){
            sb.append(sbs[i]);
        }
        return sb.toString();
    }
}