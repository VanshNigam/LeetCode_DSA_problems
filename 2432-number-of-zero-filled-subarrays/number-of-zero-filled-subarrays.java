class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        int n = nums.length;
        int prev = -1, i = 0;

        while (i < n) {
            if (nums[i] == 0) {
                ans += (i - prev);
            } else {
                prev = i;
            }
            i++;
        }
        return ans;
    }
}