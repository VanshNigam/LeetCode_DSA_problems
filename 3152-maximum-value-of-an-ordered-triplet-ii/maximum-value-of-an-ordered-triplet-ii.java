class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;

        long diffMax = 0, ans = 0, ithMax = 0;

        for (int i = 0; i < n; i++) {

            ans = Math.max(ans, diffMax * nums[i]);
            diffMax = Math.max(diffMax, ithMax - nums[i]);
            ithMax = Math.max(ithMax, nums[i]);
        }
        return ans;
    }
}