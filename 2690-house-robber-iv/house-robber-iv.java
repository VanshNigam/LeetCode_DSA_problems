class Solution {
    public int minCapability(int[] nums, int k) {
        int start = 0;
        int end = (int)1e9;
        int ans = 0;
        while (end >= start) {
            int mid = start + (end - start)/2;
            if (check(nums, mid, k)) {
                ans = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return ans;
    }
    public boolean check(int[] nums, int mid, int k) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= mid) {
                i++;
                k--;
                if (k == 0)return true;
            }
        }
        return k == 0;
    }
}