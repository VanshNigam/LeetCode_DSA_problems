class Solution {
    public int helper(int[][] grid, int x, int y, int dp[][]) {
        if (grid[0].length <= y || y < 0) return Integer.MAX_VALUE;
        if (x == grid.length - 1) return grid[x][y];
        if (dp[x][y] != Integer.MAX_VALUE) return dp[x][y];

        int back = helper(grid, x + 1, y - 1, dp); // diagonal left-down
        int down = helper(grid, x + 1, y, dp); // straight down
        int forw = helper(grid, x + 1, y + 1, dp); // diagonal right-down

        int temp = Math.min(back, Math.min(down, forw)); // take minimum among 3 options

        dp[x][y] = grid[x][y] + temp;
        return dp[x][y];
    }

    public int minFallingPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        for (int[] arr : dp) Arrays.fill(arr, Integer.MAX_VALUE);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < grid[0].length; i++) // iterate columns, not rows
            min = Math.min(helper(grid, 0, i, dp), min);
        return min;
    }
}