class Solution {
    public int compress(char[] chars) {
        if(chars.length <= 1)
            return chars.length;
        char prevChar = chars[0];
        int cnt = 1;
        int ret = 0;
        int ptr = 1;
        for(int i = 1; i < chars.length; i++){
            if(prevChar == chars[i]){
                cnt += 1;
            } else {
                if(cnt == 1){
                    ret += 1;
                } else if (cnt < 10){
                    chars[ptr++] = (char) (cnt + '0');
                    ret += 2;
                } else if (cnt < 100){
                    chars[ptr++] = (char) (cnt / 10 + '0');
                    chars[ptr++] = (char) (cnt % 10 + '0');
                    ret += 3;
                } else if (cnt < 1000){
                    chars[ptr++] = (char) (cnt / 100 + '0');
                    chars[ptr++] = (char) ((cnt / 10) % 10 + '0');
                    chars[ptr++] = (char) (cnt % 10 + '0');
                    ret += 4;
                } else {
                    chars[ptr++] = (char) (cnt / 1000 + '0');
                    chars[ptr++] = (char) ((cnt / 100) % 10 + '0');
                    chars[ptr++] = (char) ((cnt / 10) % 10 + '0');
                    chars[ptr++] = (char) (cnt % 10 + '0');
                    ret += 5;
                }
                cnt = 1;
                chars[ptr++] = chars[i];
                prevChar = chars[i];
            }
        }
        if(cnt == 0){
            ret += 0;
        } else if(cnt == 1){
            ret += 1;
        } else if (cnt < 10){
            chars[ptr++] = (char) (cnt + '0');
            ret += 2;
        } else if (cnt < 100){
            chars[ptr++] = (char) (cnt / 10 + '0');
            chars[ptr++] = (char) (cnt % 10 + '0');
            ret += 3;
        } else if (cnt < 1000){
            chars[ptr++] = (char) (cnt / 100 + '0');
            chars[ptr++] = (char) ((cnt / 10) % 10 + '0');
            chars[ptr++] = (char) (cnt % 10 + '0');
            ret += 4;
        } else {
            chars[ptr++] = (char) (cnt / 1000 + '0');
            chars[ptr++] = (char) ((cnt / 100) % 10 + '0');
            chars[ptr++] = (char) ((cnt / 10) % 10 + '0');
            chars[ptr++] = (char) (cnt % 10 + '0');
            ret += 5;
        }

        return ret;
    }
}