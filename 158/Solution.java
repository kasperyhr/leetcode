/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf); 
 */
public class Solution extends Reader4 {
    int curr = 0;
    int size = 0;
    boolean eof = false;
    char[] buffer = new char[4];
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int ptr = 0;
        while(curr < size && ptr < n){
            buf[ptr++] = buffer[curr++];
        }
        while(!eof && ptr < n){
            size = read4(buffer);
            eof = size < 4;
            curr = 0;
            while(curr < size && ptr < n){
                buf[ptr++] = buffer[curr++];
            }
        }
        return ptr;
        
    }
}