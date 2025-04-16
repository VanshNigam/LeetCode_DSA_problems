class Solution {
    public long countGood(int[] arr, int k) {
        long pairs = 0, n = arr.length, ans = 0;

        int i = 0;
        int j = 0;
        Map<Integer, Integer> mp = new HashMap<>();

        while (i < n && j < n) {
            pairs += mp.getOrDefault(arr[i], 0);
            mp.put(arr[i], mp.getOrDefault(arr[i], 0) + 1);

            while (j <= i && (pairs) >= k) {
                ans += (n - i);
                int x = arr[j];
                int fr = mp.getOrDefault(x, 0);
                //
                mp.put(x, fr - 1);
                pairs -= (fr - 1);
                j++;
            }
            i++;
        }
        return ans;
    }
}