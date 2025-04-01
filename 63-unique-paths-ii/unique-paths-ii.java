class Solution {
    public int help(int[][] obs, int dp[][], int i, int j) {
        if (i >= dp.length || j >= dp[0].length)
            return 0;
        if (obs[i][j] == 1)
            return 0;
        if (i == dp.length - 1 && j == dp[0].length - 1)
            return 1;
        if (dp[i][j] != -1)
            return dp[i][j];

        // Move down and right
        int d = help(obs, dp, i + 1, j);
        int r = help(obs, dp, i, j + 1);

        return dp[i][j] = d + r;
    }

    public int uniquePathsWithObstacles(int[][] obs) {
        int m = obs.length;
        int n = obs[0].length;

        int dp[][] = new int[m][n];
        for (int p[] : dp)
            Arrays.fill(p, -1);

        return help(obs, dp, 0, 0);
    }
}
