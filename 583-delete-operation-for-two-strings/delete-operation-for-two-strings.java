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

    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][] = new int[text1.length() + 1][text2.length() + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return help(text1, text2, 0, 0, dp);
    }
    public int minDistance(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();
        
        return l1 + l2 - 2 * longestCommonSubsequence(str1,str2);
    }
}