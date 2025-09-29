class Solution {
    // Devide a polyegon in :
    // start =i
    // end=j;
    // take a point as k
    public int solve(int values[], int i, int j, int dp[][]) {
        if (i + 1 == j) {
            return 0;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int res = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            res = Math.min(res, values[i] * values[k] * values[j] + solve(values, i, k, dp) + solve(values, k, j, dp));
        }
        dp[i][j] = res;
        return res;
    }

    public int minScoreTriangulation(int[] values) {
        int dp[][] = new int[values.length][values.length];
        return solve(values, 0, values.length - 1, dp);
    }
}