class Solution {
    public boolean possible(int[] arr, int days, int mid) {
        int curr = 0, c = 1;
        for (int i = 0; i < arr.length; i++) {
            if ((curr + arr[i]) > mid) {
                curr = 0;
                c++;
            }
            curr += arr[i];
        }
        // System.out.println(c);
        return c <= days;
    }

    public int shipWithinDays(int[] arr, int days) {
        int l = Arrays.stream(arr).max().getAsInt();
        int r = Arrays.stream(arr).sum();
        int ans = 0;

        while (l <= r) {
            int mid = (l + r) / 2;

            boolean poss = possible(arr, days, mid);
            if (poss) {
                r = mid - 1;
                ans = mid;
            } else {
                l = mid + 1;
            }
        }
        return ans;
    }
}