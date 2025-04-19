
class Solution {
    private int lowerBound(int[] v, int start, int target) {
        int end = v.length;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (v[mid] >= target)
                end = mid;
            else
                start = mid + 1;
        }
        return start;
    }

    public int upperBound(int[] v, int start, int target) {
        int end = v.length;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (v[mid] > target)
                end = mid;
            else
                start = mid + 1;
        }
        return start;
    }

    public long countFairPairs(int[] nums, int lower, int upper) {

        Arrays.sort(nums);
        int n = nums.length;
        long count = 0;

        for (int i = 0; i < n - 1; i++) {
            int x = nums[i];
            int left = lowerBound(nums, i+1, lower - x);
            int right = upperBound(nums, i+1, upper - x);
            count += Math.abs(right - left);
        }

        return count;
    }
}