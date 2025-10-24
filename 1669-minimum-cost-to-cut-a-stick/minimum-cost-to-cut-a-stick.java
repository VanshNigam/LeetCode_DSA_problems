class Solution {
    public int dfs(int i, int j, ArrayList<Integer> arr, int dp[][]) {
        if (j < i)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        int ans = Integer.MAX_VALUE;
        for (int k = i; k <= j; k++) {
            int cost = arr.get(j + 1) - arr.get(i - 1)
                    + dfs(i, k - 1, arr, dp)
                    + dfs(k + 1, j, arr, dp);
            ans = Math.min(ans, cost);
        }
        return dp[i][j] = (ans == Integer.MAX_VALUE ? 0 : ans);
    }

    public int minCost(int n, int[] cuts) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int c : cuts) arr.add(c);
        int m = arr.size();

        arr.add(0, 0);
        arr.add(n);
        Collections.sort(arr);

        int[][] dp = new int[m+1][m+1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return dfs(1, m, arr, dp);
    }
}