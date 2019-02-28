/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf);
 */
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int curr = 0;
        boolean eof = false;
        char[] buffer = new char[4];
        while(!eof && curr < n){
            int cnt = read4(buffer);
            eof = cnt < 4;
            int ptr = 0;
            while(ptr < cnt && curr < n){
                buf[curr++] = buffer[ptr++];
            }
        }
        return curr;
    }
}