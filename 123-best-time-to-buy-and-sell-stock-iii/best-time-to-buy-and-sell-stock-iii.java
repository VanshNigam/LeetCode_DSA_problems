class Solution {
    public int help(int[] p, int i, int k, int flag, int[][][] dp) {
        if (i == p.length || k == 0)
            return 0; 

        if (dp[i][k][flag] != -1)
            return dp[i][k][flag];

        int ans;
        if (flag == 1) { // Can buy
            int buy = -p[i] + help(p, i + 1, k, 0, dp); // Buy stock
            int notBuy = help(p, i + 1, k, 1, dp); // Skip buying
            ans = Math.max(buy, notBuy);
        } else { // Can sell
            int sell = p[i] + help(p, i + 1, k - 1, 1, dp); // Sell stock
            int notSell = help(p, i + 1, k, 0, dp); // Skip selling
            ans = Math.max(sell, notSell);
        }

        return dp[i][k][flag] = ans;
    }

    public int maxProfit(int[] p) {
        int[][][] dp = new int[p.length][3][2]; // [index][remaining transactions][can buy/sell]
        for (int[][] d : dp)
            for (int[] row : d)
                java.util.Arrays.fill(row, -1); // Initialize all DP states

        return help(p, 0, 2, 1, dp);
    }
}
