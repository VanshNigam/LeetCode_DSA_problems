class Solution {
    public int help(String x, String y, int i, int j, int dp[][]) {
        if (i == x.length() || j == y.length())
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];

        if (x.charAt(i) == y.charAt(j)) {
            dp[i][j] = 1 + help(x, y, i + 1, j + 1, dp);
        } else {
            dp[i][j] = Math.max(help(x, y, i + 1, j, dp), help(x, y, i, j + 1, dp));
        }
        return dp[i][j];
    }

    public int minInsertions(String s) {
        int dp[][] = new int[s.length() + 1][s.length() + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        String rev = "";
        for (int i = 0; i < s.length(); i++)
            rev = s.charAt(i) + rev;
        return s.length() - help(s, rev, 0, 0, dp);
    }
}