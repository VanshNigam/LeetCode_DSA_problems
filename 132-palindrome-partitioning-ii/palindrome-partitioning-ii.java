class Solution {
    static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public int help(String s, int i, int dp[]) {
        int n = s.length();
        if (i == n)
            return 0;
        if (dp[i] != -1)
            return dp[i];

        int ans = Integer.MAX_VALUE;

        for (int j = i + 1; j <= n; j++) {
            int sum = Integer.MAX_VALUE;
            if (isPalindrome(s.substring(i, j))) {
                ans = Math.min(ans, 1 + help(s, j, dp));
            }
        }
        return dp[i] = ans;
    }

    public int minCut(String s) {
        int dp[] = new int[s.length()];
        Arrays.fill(dp, -1);
        return help(s, 0, dp) - 1;
    }
}