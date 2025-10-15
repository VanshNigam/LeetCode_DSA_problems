class Solution {
    // int min = Integer.MAX_VALUE;

    public int help(int[] coins, int amount, int curr, int i, int dp[][]) {
        if (i >= coins.length || curr > amount ) {
            if (curr == amount)
                return 0;
            return Integer.MAX_VALUE - 1;
        }

        if (dp[i][curr] != -1)
            return dp[i][curr];

        int take = Integer.MAX_VALUE - 1;
        int not_take = Integer.MAX_VALUE;
        if (amount - curr >= coins[i])
            take = 1 + help(coins, amount, curr + coins[i], i, dp);
        not_take = help(coins, amount, curr, i + 1, dp);

        return dp[i][curr] = Math.min(take, not_take);
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int dp[][] = new int[n][amount + 1];

        for (int i[] : dp)
            Arrays.fill(i, -1);

        int min = help(coins, amount, 0, 0, dp);
        return (min >= Integer.MAX_VALUE - 1) ? -1 : min;
    }
}