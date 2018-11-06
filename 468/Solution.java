class Solution {
    public String validIPAddress(String IP) {
        String match0255 = "((1[0-9][0-9])|([1-9][0-9])|([0-9])|(2[0-4][0-9])|(25[0-5]))";
        String matchipv4 = match0255 + "\\." + match0255 + "\\." + match0255 + "\\." + match0255;
        if(IP.matches(matchipv4)){
            return "IPv4";
        }
        String ipv6OneDigit = "[0-9a-fA-F]";
        String ipv6OneChunk = "(" + ipv6OneDigit + "?" + ipv6OneDigit + "?" + ipv6OneDigit + "?" + ipv6OneDigit + ")";
        String matchipv6 = ipv6OneChunk + ":" + ipv6OneChunk + ":" + ipv6OneChunk + ":" + ipv6OneChunk + ":" + ipv6OneChunk + ":" + ipv6OneChunk + ":" + ipv6OneChunk + ":" + ipv6OneChunk;
        if(IP.matches(matchipv6)){
            return "IPv6";
        }
        return "Neither";
    }
}