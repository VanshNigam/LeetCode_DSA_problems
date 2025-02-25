class Solution {
    public int numOfSubarrays(int[] arr) {
        int c = 0, n = arr.length;

        int even = 0;
        int odd = 0;
        int sum = 0;
        int mod = 1000000007;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum % 2 == 0) {
                c += odd;
                even++;
            } else {
                c += (even + 1);
                odd++;
            }
            c = c % mod;
        }
        return c % mod;
    }
}