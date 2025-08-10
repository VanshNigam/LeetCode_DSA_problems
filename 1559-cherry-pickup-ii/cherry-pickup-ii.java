class Solution {
    int help(int[][] arr, int i, int j1, int j2, int dp[][][]) {
        int n = arr.length;
        int m = arr[0].length;

        if (j1 < 0 || j1 > m - 1 || j2 < 0 || j2 > m - 1)
            return -(int) 1e8;

        if (i == n - 1) {
            if (j1 == j2)
                return arr[i][j1];
            else
                return arr[i][j1] + arr[i][j2];
        }
        if (dp[i][j1][j2] != -1)
            return dp[i][j1][j2];
        int max = Integer.MIN_VALUE;
        for (int dj1 = -1; dj1 < 2; dj1++) {
            for (int dj2 = -1; dj2 < 2; dj2++) {
                if (j1 == j2)
                    max = Math.max(max, arr[i][j1] + help(arr, i + 1, dj1 + j1, dj2 + j2, dp));
                else
                    max = Math.max(max, arr[i][j1] + arr[i][j2] + help(arr, i + 1, dj1 + j1, dj2 + j2, dp));
            }
        }
        return dp[i][j1][j2] = max;
    }

    public int cherryPickup(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int dp[][][] = new int[n][m][m];

        for (int i[][] : dp)
            for (int j[] : i)
                Arrays.fill(j, -1);
        return help(arr, 0, 0, m - 1, dp);
    }
}