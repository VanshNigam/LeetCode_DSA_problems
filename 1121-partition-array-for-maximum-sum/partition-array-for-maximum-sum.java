class Solution {
    public int help(int arr[], int k, int i, int dp[]) {
        int n = arr.length;
        if (i == n)
            return 0;
        if (dp[i] != -1)
            return dp[i];

        int len = 0;
        int maxNumber = Integer.MIN_VALUE;
        int ans = Integer.MIN_VALUE;
        for (int j = i; j < Math.min(n, i + k); j++) {
            len++;
            maxNumber = Math.max(maxNumber, arr[j]);
            int sum = len * maxNumber + help(arr, k, j + 1, dp);

            ans = Math.max(ans, sum);
        }
        return dp[i] = ans;
    }

    public int maxSumAfterPartitioning(int[] arr, int k) {
        int dp[] = new int[arr.length];
        Arrays.fill(dp, -1);
        return help(arr, k, 0, dp);
    }
}