class Solution {
    public int bfs(int grid[][], int i, int j) {
        if (i >= grid.length || i < 0 || j >= grid[0].length || j < 0 || grid[i][j] == 0)
            return 0;

        int ans = 0;
        if (grid[i][j] == 1) {
            grid[i][j] = 0;
            ans += bfs(grid, i + 1, j);
            ans += bfs(grid, i - 1, j);
            ans += bfs(grid, i, j + 1);
            ans += bfs(grid, i, j - 1);
        }

        return ans + 1;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    max = Math.max(bfs(grid, i, j), max);
            }
        }
        return max;
    }
}