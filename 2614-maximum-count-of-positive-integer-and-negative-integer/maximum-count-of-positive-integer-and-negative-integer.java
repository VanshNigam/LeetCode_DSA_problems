
class Solution {
    public int maximumCount(int[] nums) {
        int n = nums.length;

        int l = 0;
        int r = n - 1;
        int neg = n;

        while (l <= r) {
            int mid = (r + l) / 2;
            if (nums[mid] >= 0) {
                neg = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        l = 0;
        r = n - 1;
        int pos = n;

        while (l <= r) {
            int mid = (r + l) / 2;
            if (nums[mid] <= 0) {
                l = mid + 1;
            } else {
                pos = mid;
                r = mid - 1;
            }
        }
        return Math.max(n - pos, neg);
    }
}