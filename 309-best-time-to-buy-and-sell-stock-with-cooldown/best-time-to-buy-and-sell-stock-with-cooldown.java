class Solution {
    // int
    public int help(int[] p, int i, int prevInd, int k, int flag, int dp[][]) {
        if (i >= p.length || k < 1)
            return 0;
        int buy = 0;
        int notbuy = 0;
        int sell = 0;
        int notSell = 0;
        if (dp[i][flag] != -1)
            return dp[i][flag];
        if (flag == 1) {
            buy = -p[i] + help(p, i + 1, i, k, 0, dp);
            notbuy = help(p, i + 1, 0, k, 1, dp);
        } else {
            sell = p[i] + help(p, i + 2, 0, k - 1, 1, dp);
            notSell = help(p, i + 1, prevInd, k, 0, dp);
        }
        return dp[i][flag] = Math.max(buy, Math.max(sell, Math.max(notbuy, notSell)));
    }

    public int maxProfit(int[] p) {
        int dp[][] = new int[p.length][2];

        for (int x[] : dp) {

            x[0] = -1;
            x[1] = -1;

        }
        return help(p, 0, 0, p.length, 1, dp);
    }
}