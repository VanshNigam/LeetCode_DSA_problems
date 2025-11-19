class Solution {
    public int findFinalValue(int[] nums, int original) {
        boolean[] dp = new boolean[1001];
        for (int i : nums)
            dp[i] = true;
        while (original < 1001 && dp[original])
            original <<= 1;
        return original;
    }
}