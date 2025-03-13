class Solution {
    public boolean isZeroArray(int[] nums, int[][] qr) {
        int n = nums.length;
        int psum[] = new int[n + 1];

        for (int q[] : qr) {
            psum[q[0]] -= 1;
            psum[q[1] + 1] += 1;
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += psum[i];
            if (sum + nums[i] > 0)
                return false;
        }
        return true;
    }
}