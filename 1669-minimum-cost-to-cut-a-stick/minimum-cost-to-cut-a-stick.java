class Solution {
    public int minCost(int N, int[] cuts) {
        int n = cuts.length;
        int[] arr = new int[n + 2];
        arr[0] = 0;
        arr[n + 1] = N;

        Arrays.sort(cuts);
        for (int i = 1; i <= n; i++) arr[i] = cuts[i - 1];

        int[][] dp = new int[n + 2][n + 2];

        for (int i = n; i >= 1; i--) {
            for (int j = i; j <= n; j++) {
                int mini = Integer.MAX_VALUE;
                for (int ind = i; ind <= j; ind++) {
                    int cost = arr[j + 1] - arr[i - 1] + dp[i][ind - 1] + dp[ind + 1][j];
                    mini = Math.min(mini, cost);
                }
                dp[i][j] = mini;
            }
        }
        return dp[1][n];
    }
}