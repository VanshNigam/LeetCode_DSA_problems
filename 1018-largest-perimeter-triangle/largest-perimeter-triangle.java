class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            int a = nums[i - 2], b = nums[i - 1], c = nums[i];
            if (a + b > c) {
                return a + b + c; // largest perimeter found
            }
        }
        return 0; // no triangle possible
    }
}
