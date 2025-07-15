class Solution {
    public void bfs(int[][] mat, int[][] ans, boolean[][] vis, Queue<int[]> q) {
        int n = mat.length;
        int m = mat[0].length;

        int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int ind[] = q.poll();
                int x = ind[0];
                int y = ind[1];
                for (int d[] : dirs) {
                    int nx = x + d[0];
                    int ny = y + d[1];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= m || vis[nx][ny])
                        continue;
                    vis[nx][ny] = true;
                    ans[nx][ny] = ans[x][y] + 1;
                    q.add(new int[] { nx, ny });
                }
            }

        }
    }

    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int ans[][] = new int[n][m];
        for (int i[] : ans) {
            Arrays.fill(i, n * m);
        }

        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    ans[i][j] = 0;
                    vis[i][j] = true;
                    q.add(new int[] { i, j });
                }
            }
        }
        bfs(mat, ans, vis, q);
        return ans;
    }
}