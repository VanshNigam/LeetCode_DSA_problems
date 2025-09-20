class Solution {
    int c = 0;

    public void help(int nums[], int tar, int curr, int i) {
        if (i == nums.length) {
            if (curr == tar)
                c++;
            return;
        }

        help(nums, tar, curr + nums[i], i + 1);
        help(nums, tar, curr - nums[i], i + 1);
    }

    public int findTargetSumWays(int[] nums, int target) {
        help(nums, target, 0, 0);
        return c;
    }
}