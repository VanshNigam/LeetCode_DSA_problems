class Solution {
    public int minimumDifference(int[] nums, int k) {
        if (k == 1)
            return 0;
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i <= nums.length - k; i++) {
            min = nums[i];
            max = nums[k + i - 1];

            ans = Math.min(ans, max - min);
        }

        return ans;
    }
}