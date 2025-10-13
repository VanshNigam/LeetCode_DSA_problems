class Solution {
    public int help(int nums[], int i, int prev, int dp[][]) {
        if (i >= nums.length)
            return 0;

        if (dp[i][prev + 1] != -1)
            return dp[i][prev + 1];
        int take = 0;
        int nottake = 0;

        if (prev == -1 || prev != i - 1) {
            take = nums[i] + help(nums, i + 1, i, dp);
        }
        nottake = help(nums, i + 1, prev, dp);

        return dp[i][prev + 1] = Math.max(take, nottake);
    }

    public int rob(int[] nums) {
        int dp[][] = new int[nums.length + 1][nums.length + 1];
        for (int i[] : dp) {
            Arrays.fill(i, -1);
        }
        return help(nums, 0, -1, dp);
    }
}