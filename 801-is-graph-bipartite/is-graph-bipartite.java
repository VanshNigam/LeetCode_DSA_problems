class Solution {
    public boolean dfs(int i, int col, int color[], int[][] adj) {
        color[i] = col;
        for (int neigh : adj[i]) {
            if (color[neigh] == -1) {
                // int newCol = (col == 0) ? 1 : 0;
                if (!dfs(neigh, 1 - col, color, adj))
                    return false;
            } else if (color[neigh] == col)
                return false;
        }
        return true;
    }

    public boolean isBipartite(int[][] g) {
        int n = g.length;
        int color[] = new int[n];
        for (int i = 0; i < n; i++)
            color[i] = -1;

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!dfs(i, 0, color, g))
                    return false;
            }
        }
        return true;
    }
}