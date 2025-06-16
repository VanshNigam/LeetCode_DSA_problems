class Solution {
    public int maximumDifference(int[] nums) {
        int min = Integer.MAX_VALUE;
        int small[] = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (min > nums[i]) {
                min = nums[i];
            }
            small[i] = min;
        }
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            if (max < (nums[i] - small[i])) {
                max = nums[i] - small[i];
            }
        }
        return max == 0 ? -1 : max;
    }
}