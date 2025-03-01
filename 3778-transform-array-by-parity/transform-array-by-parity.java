class Solution {
    public int[] transformArray(int[] nums) {
        int n = nums.length;
        int even = 0;
        int odd = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0)
                even++;
            else
                odd++;
        }

        for (int i = 0; i < n; i++) {
            if (even > 0) {
                nums[i] = 0;
                even--;
            } else {
                nums[i] = 1;
                odd--;
            }
        }

        return nums;
    }
}