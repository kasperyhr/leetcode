class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        if(bits[bits.length - 1] == 1)
            return false;
        for(int i = 0; i < bits.length; i++){
            if(bits[i] == 1)
                i++;
            else if(i == bits.length - 1)
                return true;
        }
        return false;
    }
}