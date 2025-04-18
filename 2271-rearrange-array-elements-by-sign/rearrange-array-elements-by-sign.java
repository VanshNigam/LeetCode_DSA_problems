class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] arr = new int[nums.length];
        int k = 0, k2 = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0 && k < nums.length) {
                arr[k] = nums[i];
                k += 2;
            } else if (nums[i] < 0 && k2 < nums.length) {
                arr[k2] = nums[i];
                k2 += 2;
            }
        }
        return arr;
    }
}
