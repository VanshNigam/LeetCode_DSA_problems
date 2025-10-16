class Solution {
    public int help(int[] coins, int amount, int curr, int i, int dp[][]) {
        if (i >= coins.length || curr > amount ) {
            if (curr == amount)
                return 1;
            return 0;
        }

        if (dp[i][curr] != -1)
            return dp[i][curr];

        int take = 0;
        int not_take = 0;
        if (amount - curr >= coins[i])
            take = help(coins, amount, curr + coins[i], i, dp);
        not_take = help(coins, amount, curr, i + 1, dp);

        return dp[i][curr] = take + not_take;
    }

    public int change(int amount, int[] coins) {
        int n = coins.length;

        int dp[][] = new int[n][amount + 1];

        for (int i[] : dp)
            Arrays.fill(i, -1);

        int min = help(coins, amount, 0, 0, dp);
        return min;
    }
}