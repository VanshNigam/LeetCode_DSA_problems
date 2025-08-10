class Solution {
    public boolean help(int arr[], int i, int curr, int tar, Boolean dp[][]) {
        if (i == arr.length || curr > tar)
            return false;
        if (tar == curr)
            return true;
        
        // Memoization check
        if (dp[i][curr] != null)
            return dp[i][curr];
        
        // Include current element OR skip it
        boolean take = help(arr, i + 1, curr + arr[i], tar, dp);
        boolean skip = help(arr, i + 1, curr, tar, dp);
        
        return dp[i][curr] = (take || skip);
    }

    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int i : nums)
            total += i;
        if (total % 2 != 0)
            return false;
        
        Boolean dp[][] = new Boolean[nums.length][total / 2 + 1];
        return help(nums, 0, 0, total / 2, dp);
    }
}
