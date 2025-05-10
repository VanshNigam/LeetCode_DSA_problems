class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        int x = 0;
        int y = 0;

        long  sum1 = 0;
        long  sum2 = 0;
        for (int i : nums1) {
            sum1 += i;
            if (i == 0) {
                x++;
            }
        }
        for (int i : nums2) {
            sum2 += i;
            if (i == 0) {
                y++;
            }
        }
        if (x == 0 && y == 0)
            return sum1 == sum2 ? sum1 : -1;
        if (x == 0)
            return y + sum2 <= sum1 ? sum1 : -1;
        if (y == 0)
            return x + sum1 <= sum2 ? sum2 : -1;

        return Math.max(sum2 + y, sum1 + x);
    }
}