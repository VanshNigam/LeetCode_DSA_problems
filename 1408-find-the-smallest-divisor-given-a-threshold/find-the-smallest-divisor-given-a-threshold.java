class Solution {
    public int max(int arr[]) {
        int max = 0;
        for (int i : arr)
            max = Math.max(max, i);
        return max;
    }

    public int sum(int arr[], int d) {
        int sum = 0;
        for (int i : arr)
            sum += Math.ceil((double) i / d);
        return sum;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int l = 1;
        int r = max(nums), ans = 0;

        while (l <= r) {
            int mid = (l + r) / 2;
            int sum = sum(nums, mid);
            if (sum <= threshold) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
            // System.out.println(r+" : "+l);
        }
        return ans;
    }
}