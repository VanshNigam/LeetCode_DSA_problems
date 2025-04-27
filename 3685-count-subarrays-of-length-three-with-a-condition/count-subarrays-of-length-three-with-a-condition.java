class Solution {
    public int countSubarrays(int[] nums) {
        if (nums.length <= 2)
            return 0;
        int c = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (j - i == 2) {
                    if ((nums[j] + nums[i]) == nums[i + 1] / 2.0)
                        c += 1;
                }
            }
        }
        return c;
    }
}