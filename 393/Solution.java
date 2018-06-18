class Solution {
    public boolean validUtf8(int[] data) {
        for(int i = 0; i < data.length; i++){
            if((data[i] & 128) == 0){
                continue;
            } else if ((data[i] & 224) == 192){
                if(i + 1 >= data.length)
                    return false;
                if((data[++i] & 192) != 128)
                    return false;
            } else if((data[i] & 240) == 224){
                if(i + 2 >= data.length)
                    return false;
                if((data[++i] & 192) != 128)
                    return false;
                if((data[++i] & 192) != 128)
                    return false;                
            } else if((data[i] & 248) == 240){
                if(i + 2 >= data.length)
                    return false;
                if((data[++i] & 192) != 128)
                    return false;
                if((data[++i] & 192) != 128)
                    return false;
                if((data[++i] & 192) != 128)
                    return false;
            } else 
                return false;
            
        }
        return true;    
    }
}