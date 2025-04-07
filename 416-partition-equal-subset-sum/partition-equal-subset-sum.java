class Solution {
    public boolean help(int[] nums, int i, int sum, int dp[][]) {
        if (i == nums.length || sum < 0)
            return false;
        if (sum == 0)
            return true;
        if (dp[i][sum] != -1)
            return dp[i][sum] == 1;
        //take or not take
        boolean take = false;
        boolean nottake = false;

        take = help(nums, i + 1, sum - nums[i], dp);
        nottake = help(nums, i + 1, sum, dp);

        boolean t = take || nottake;
        dp[i][sum] = t == false ? 0 : 1;
        return t;
    }

    public boolean canPartition(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();

        int sum = 0;
        for (int i : nums)
            sum += i;

        if (sum % 2 != 0)
            return false;
        int dp[][] = new int[nums.length][sum + 1];
        for (int i[] : dp)
            Arrays.fill(i, -1);
        return help(nums, 0, sum / 2, dp);
    }
}