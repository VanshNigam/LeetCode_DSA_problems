class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int i = 0, l = 0;
        int jump = 0;

        while (i < n - 1) {
            int max = 0;
            for (int ind = l; ind <= i; ind++) {
                max = Math.max(ind + nums[ind], max);
            }
            l = i + 1;
            i = max;
            jump++;
        }
        return jump;
    }
}