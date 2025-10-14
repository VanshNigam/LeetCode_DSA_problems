class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();

        int dp[][] = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = triangle.get(n - 1).get(i);
        }

        // Bottom up
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                int down = dp[i + 1][j];
                int daig = dp[i + 1][j + 1];

                dp[i][j] = Math.min(down, daig) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }
}