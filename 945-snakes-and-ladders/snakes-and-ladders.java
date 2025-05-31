class Solution {
    int n;

    public int[] getCord(int val) {
        int rt = (val - 1) / n;
        int rb = (n - 1) - rt;

        int col = (val - 1) % n;
        if ((n % 2 == 1 && rb % 2 == 1) || (n % 2 != 1 && rb % 2 != 1))
            col = (n - 1) - col;

        return new int[] { rb, col };
    }

    public int snakesAndLadders(int[][] board) {
        n = board.length;
        int step = 0;

        Queue<Integer> q = new LinkedList<>();

        boolean vis[][] = new boolean[n][n];
        q.add(1);

        while (!q.isEmpty()) {
            int l = q.size();
            for (int i = 0; i < l; i++) {
                int x = q.poll();
                if (x == n * n)
                    return step;

                for (int k = 1; k <= 6; k++) {
                    int val = x + k;
                    if (val > n * n)
                        break;
                    int cordinate[] = getCord(val);
                    int r = cordinate[0];
                    int c = cordinate[1];

                    if (vis[r][c])
                        continue;
                    vis[r][c] = true;

                    if (board[r][c] == -1)
                        q.add(x + k);
                    else
                        q.add(board[r][c]);
                }
            }
            step++;
        }
        return -1;
    }
}