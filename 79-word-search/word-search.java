class Solution {
    private int rows;
    private int cols;
    boolean vis[][];

    public boolean bfs(char[][] board, int r, int c, String word, int ind) {
        if (ind == word.length())
            return true;

        if (r < 0 || r >= rows || c < 0 || c >= cols || vis[r][c] || board[r][c] != word.charAt(ind)) {
            return false;
        }
        vis[r][c] = true;
        boolean res = bfs(board, r + 1, c, word, ind + 1) ||
                bfs(board, r - 1, c, word, ind + 1) ||
                bfs(board, r, c + 1, word, ind + 1) ||
                bfs(board, r, c - 1, word, ind + 1);
        vis[r][c] = false;
        return res;
    }

    public boolean exist(char[][] board, String word) {
        rows = board.length;
        cols = board[0].length;
        vis = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (bfs(board, i, j, word, 0))
                    return true;
            }
        }
        return false;
    }
}