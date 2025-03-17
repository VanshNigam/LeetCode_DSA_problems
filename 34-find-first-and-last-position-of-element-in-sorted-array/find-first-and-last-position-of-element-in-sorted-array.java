class Solution {
    public int[] searchRange(int[] nums, int target) {
        int f = -1, second = -1;
        int n = nums.length;
        int l = 0;
        int r = n ;

        while (l < r) {
            int m = (l + r) / 2;
            if (nums[m] == target)
                second = m;
            if (nums[m] <= target)
                l = m + 1;
            else
                r = m;
        }

        l = 0;
        r = n ;
        while (l < r) {
            int m = (l + r) / 2;
            if (nums[m] == target)
                f = m;
            if (nums[m] >= target)
                r = m;
            else
                l = m + 1;
        }

        return new int[] { f, second };

    }
}