class Solution {
    public long help(int[][] q, int i, long dp[]) {
        //Base Case
        if (i >= q.length)
            return 0l;
        if (dp[i] != -1)
            return dp[i];
        //recursion
        long notTake = 0;
        notTake = help(q, i + 1, dp);

        long take = q[i][0];
        int skip = q[i][1];
        if (i + skip + 1 < q.length)
            take += help(q, i + skip + 1, dp);
        //dp store
        return dp[i] = Math.max(take, notTake);
    }

    public long mostPoints(int[][] q) {

        long dp[] = new long[q.length];
        Arrays.fill(dp, -1);
        return help(q, 0, dp);
    }
}