class Solution {
    public int[] pivotArray(int[] nums, int p) {
        int n = nums.length;
        int arr[] = new int[n];

        int st = 0;
        int end = n - 1;

        for (int i = 0, j = n - 1; i < n; i++, j--) {
            if (nums[i] < p) {
                arr[st] = nums[i];
                st++;
            }
            if (nums[j] > p) {
                arr[end] = nums[j];
                end--;
            }
        }
        while (st <= end) {
            arr[st] = p;
            st++;
        }
        return arr;
    }
}