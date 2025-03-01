class Solution {
   int[][] dp;

    int solve(int[] nums, int i, int last){
        if(i+1 >= nums.length) return Math.max(nums[last], (i < nums.length?nums[i]:0));
        if(dp[i][last] != -1) return dp[i][last];
        int res = Math.max(nums[i], nums[i+1]) +  solve(nums, i+2,  last);
        res = Math.min(res, Math.max(nums[i], nums[last])   + solve(nums, i+2, i+1));
        res = Math.min(res, Math.max(nums[i+1], nums[last]) + solve(nums, i+2, i));
        return dp[i][last] = res;
    }

    int minCost(int[] nums) {
        dp = new int[1001][1001];
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
        return solve(nums, 1, 0);
    }
}