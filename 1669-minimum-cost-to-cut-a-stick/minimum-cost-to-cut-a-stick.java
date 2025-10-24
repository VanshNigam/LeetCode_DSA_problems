class Solution {
    // public int dfs(int i, int j, ArrayList<Integer> arr, int dp[][]) {
    //     if (j < i)
    //         return 0;

    //     if (dp[i][j] != -1)
    //         return dp[i][j];

    //     int ans = Integer.MAX_VALUE;
    //     for (int k = i; k <= j; k++) {
    //         int cost = arr.get(j + 1) - arr.get(i - 1)
    //                 + dfs(i, k - 1, arr, dp)
    //                 + dfs(k + 1, j, arr, dp);
    //         ans = Math.min(ans, cost);
    //     }
    //     return dp[i][j] = (ans == Integer.MAX_VALUE ? 0 : ans);
    // }

    public int minCost(int n, int[] cuts) {
        // ArrayList<Integer> arr = new ArrayList<>();
        // for (int c : cuts) arr.add(c);
        // int m = arr.size();

        // arr.add(0, 0);
        // arr.add(n);
        // Collections.sort(arr);

        // int[][] dp = new int[m+1][m+1];
        // for (int[] row : dp) Arrays.fill(row, -1);

        // return dfs(1, m, arr, dp);

        //tabulation-----------------

        //base case
        
        ArrayList<Integer> arr = new ArrayList<>();
        for (int c : cuts)
            arr.add(c);
        int m = arr.size();

        arr.add(0, 0);
        arr.add(n);
        Collections.sort(arr);

        int[][] dp = new int[m+ 2][m + 2];
        for (int[] row : dp)
            Arrays.fill(row, 0);

        for (int i = m; i >= 1; i--) {
            for (int j = 1; j <= m; j++) {
                if (j < i)
                    continue;
                int ans = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    int cost = arr.get(j + 1) - arr.get(i - 1)
                            + dp[i][k - 1]
                            + dp[k + 1][j];
                    ans = Math.min(ans, cost);
                }
                dp[i][j] = ans;
            }
        }
        return dp[1][m];
    }
}