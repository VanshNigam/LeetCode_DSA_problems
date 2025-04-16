class Solution {
    public int help(int[] arr, int k) {
        int l = 0, r = 0;
        int n = arr.length;
        int c = 0;
        Map<Integer, Integer> mp = new HashMap<>();

        while (l < n && r < n) {
            mp.put(arr[l], mp.getOrDefault(arr[l], 0) + 1);

            while (r <= l && mp.size() > k) {
                int x = arr[r];
                if (mp.getOrDefault(x, 0) > 1) {
                    mp.put(x, mp.get(x) - 1);
                } else {
                    mp.remove(x);
                }
                r++;
            }
            c += (l - r + 1);
            l++;
        }
        return c;

    }

    public int subarraysWithKDistinct(int[] nums, int k) {
        return help(nums, k) - help(nums, k - 1);
    }
}