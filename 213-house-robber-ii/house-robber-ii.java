class Solution {
    // House Rober 1st 
    public int help(int[] num, int i, int dp[]) {
        if (i >= num.length)
            return 0;
        if (dp[i] != -1)
            return dp[i];

        return dp[i] = Math.max(help(num, i + 2, dp) + num[i], help(num, i + 1, dp));
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0]; // Edge case: Only one house
        if (n == 2)
            return Math.max(nums[0], nums[1]); // Edge case: Only one house

        int dp[] = new int[nums.length];
        Arrays.fill(dp, -1);
        int removeFirst = help(Arrays.copyOfRange(nums, 0, n), 1, dp);

        Arrays.fill(dp, -1);
        int removeLast = help(Arrays.copyOfRange(nums, 0, n - 1), 0, dp);
        return Math.max(removeFirst, removeLast);
    }
}