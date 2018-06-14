import java.util.*;
public class Codec {
    HashMap<Integer, String> code = new HashMap<Integer, String>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int url = longUrl.hashCode();
        code.put(url, longUrl);
        return "" + url;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return code.get(Integer.parseInt(shortUrl));
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));