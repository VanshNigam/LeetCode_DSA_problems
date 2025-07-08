class Solution {
    int[][] dp;

    public int help(int[][] e, int i, int k) {
        if (i >= e.length || k == 0)
            return 0;
        if (dp[i][k] != -1)
            return dp[i][k];

        // Binary search to find the next event starting after e[i][1]
        int low = i + 1, high = e.length, next = e.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (e[mid][0] > e[i][1]) {
                next = mid;
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        int take = e[i][2] + help(e, next, k - 1);
        int skip = help(e, i + 1, k);

        return dp[i][k] = Math.max(take, skip);
    }

    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        dp = new int[events.length][k + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        return help(events, 0, k);
    }
}
