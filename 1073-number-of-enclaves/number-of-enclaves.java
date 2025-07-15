class Solution {
    int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public void bfs(int[][] mat, Queue<int[]> q, boolean[][] vis) {
        int n = mat.length;
        int m = mat[0].length;

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int val[] = q.poll();
                int x = val[0];
                int y = val[1];

                for (int d[] : dirs) {
                    int nx = x + d[0];
                    int ny = y + d[1];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m || vis[nx][ny] || mat[nx][ny] != 1)
                        continue;
                    vis[nx][ny] = true;
                    q.add(new int[] { nx, ny });
                    mat[nx][ny] = 2;
                }
            }
        }
    }

    public int numEnclaves(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];

        // Top and bottom rows
        for (int j = 0; j < m; j++) {
            if (mat[0][j] == 1) {
                q.add(new int[] { 0, j });
                vis[0][j] = true;
                mat[0][j] = 2;
            }
            if (mat[n - 1][j] == 1) {
                q.add(new int[] { n - 1, j });
                vis[n - 1][j] = true;
                mat[n - 1][j] = 2;
            }
        }

        // Left and right columns
        for (int i = 1; i < n - 1; i++) {
            if (mat[i][0] == 1) {
                q.add(new int[] { i, 0 });
                vis[i][0] = true;
                mat[i][0] = 2;
            }
            if (mat[i][m - 1] == 1) {
                q.add(new int[] { i, m - 1 });
                vis[i][m - 1] = true;
                mat[i][m - 1] = 2;
            }
        }

        bfs(mat, q, vis);

        int c = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    c++;
                }
            }
        }
        return c;
    }
}