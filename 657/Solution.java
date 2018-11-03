class Solution {
    public boolean judgeCircle(String moves) {
        int up = 0;
        int left = 0;
        for(int i = 0; i < moves.length(); i++){
            switch(moves.charAt(i)){
                case 'U':
                    up += 1;
                    break;
                case 'D':
                    up -= 1;
                    break;
                case 'L':
                    left += 1;
                    break;
                case 'R':
                    left -= 1;
                    break;
            }
        }
        return left == 0 && up == 0;
    }
}