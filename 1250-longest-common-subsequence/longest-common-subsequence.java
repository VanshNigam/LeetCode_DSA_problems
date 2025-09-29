class Solution {
    public int help(String x, String y, int i, int j, int dp[][]) {
        if (i >= x.length() || j >= y.length())
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        if (x.charAt(i) == y.charAt(j))
            dp[i][j] = 1 + help(x, y, i + 1, j + 1, dp);
        else
            dp[i][j] = Math.max(help(x, y, i, j + 1, dp) , help(x, y, i + 1, j, dp));

        return dp[i][j];
    }

    public int longestCommonSubsequence(String x, String y) {

        int dp[][] = new int[x.length()][y.length()];
        for (int i[] : dp)
            Arrays.fill(i, -1);
        return help(x, y, 0, 0, dp);
    }
}