class Solution {
    public int countSubarrays(int[] nums) {
        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (j - i == 2) {
                    if (nums[j] + nums[i] == nums[i + 1] / 2.0)
                        c++;
                }
            }
        }
        return c;
    }
}