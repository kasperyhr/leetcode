class Solution {
    static final char MASK_CHAR = ' ';
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> word_l = new HashSet<String>(Arrays.asList(words));
        words = new ArrayList<String>(word_l).toArray(new String[0]);
        List<String> ret = new LinkedList<String>();
        for(int i = 0; i < words.length; i++){
            if(exist(board, words[i]))
                ret.add(words[i]);
        }
        return ret;
    }
    
    private boolean exist(char[][] board, String word) {
        int M = board.length;
        int N = board[0].length;
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(dfs(board, word, M, N, i, j, 0))
                    return true;
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int M, int N, int i, int j, int len){
        if(len >= word.length())
            return true;
        if(i < 0 || i >= M)
            return false;
        if(j < 0 || j >= N)
            return false;
        if(word.charAt(len) != board[i][j])
            return false;
        char c = board[i][j];
        board[i][j] = MASK_CHAR;
        boolean flag = dfs(board, word, M, N, i - 1,   j  , len + 1)
                    || dfs(board, word, M, N, i + 1,   j  , len + 1)
                    || dfs(board, word, M, N,   i  , j + 1, len + 1)
                    || dfs(board, word, M, N,   i  , j - 1, len + 1);
        board[i][j] = c;
        return flag;
    }
}