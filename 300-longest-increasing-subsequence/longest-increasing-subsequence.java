class Solution {
    public int help(int[] nums, int dp[][], int i, int prev) {
        if (i == nums.length)
            return 0;
        if (dp[i][prev + 1] != -1)
            return dp[i][prev + 1];

        int take = 0;
        int nottake = 0;
        if (prev == -1 || nums[i] > nums[prev]) {
            take = help(nums, dp, i + 1, i) + 1;
        }
        nottake = help(nums, dp, i + 1, prev);

        return dp[i][prev + 1] = Math.max(take, nottake);
    }

    public int lengthOfLIS(int[] nums) {
        int dp[][] = new int[nums.length][nums.length];
        for (int i[] : dp)
            Arrays.fill(i, -1);
        return help(nums, dp, 0, -1);
    }
}