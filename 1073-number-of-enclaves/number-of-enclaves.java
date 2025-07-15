class Solution {
    int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public void bfs(int[][] mat, Queue<int[]> q, boolean[][] vis) {
        int n = mat.length;
        int m = mat[0].length;

        while (!q.isEmpty()) {
            int[] val = q.poll();
            int x = val[0], y = val[1];

            for (int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !vis[nx][ny] && mat[nx][ny] == 1) {
                    vis[nx][ny] = true;
                    q.offer(new int[] { nx, ny });
                }
            }
        }
    }

    public int numEnclaves(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        boolean[][] vis = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();

        // Add all border land cells to queue
        for (int i = 0; i < n; i++) {
            if (mat[i][0] == 1 && !vis[i][0]) {
                vis[i][0] = true;
                q.offer(new int[] { i, 0 });
            }
            if (mat[i][m - 1] == 1 && !vis[i][m - 1]) {
                vis[i][m - 1] = true;
                q.offer(new int[] { i, m - 1 });
            }
        }

        for (int j = 0; j < m; j++) {
            if (mat[0][j] == 1 && !vis[0][j]) {
                vis[0][j] = true;
                q.offer(new int[] { 0, j });
            }
            if (mat[n - 1][j] == 1 && !vis[n - 1][j]) {
                vis[n - 1][j] = true;
                q.offer(new int[] { n - 1, j });
            }
        }

        bfs(mat, q, vis);

        // Count unvisited land cells = enclaves
        int count = 0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (mat[i][j] == 1 && !vis[i][j])
                    count++;

        return count;
    }
}
