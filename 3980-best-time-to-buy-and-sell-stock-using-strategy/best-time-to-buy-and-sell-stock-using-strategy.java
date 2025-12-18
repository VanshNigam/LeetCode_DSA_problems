class Solution {
    public long maxProfit(int[] prices, int[] strategy, int k) {
        int n = prices.length;

        //normal profit
        long profit = 0;
        for (int j = 0; j < n; j++)
            profit += prices[j] * strategy[j];

        //best profit at any window
        long norm = 0;
        long best = 0;
        long updt = 0;
        for (int j = 0; j < k; j++) {
            norm += prices[j] * strategy[j];
            if (j >= (k/2))
                updt += prices[j];
        }
        best = Math.max(best, updt - norm);
        for (int j = k; j < n; j++) {
            norm += (long)prices[j] * strategy[j] - (long)prices[j - k] * strategy[j - k];
            updt += prices[j] - prices[j - k + (k / 2)];

            best = Math.max(best, updt - norm);
        }
        return best + profit;
    }
}