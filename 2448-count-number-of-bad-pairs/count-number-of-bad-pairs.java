class Solution {
    public long countBadPairs(int[] nums) {
        long c = 0;
        int n = nums.length;

        //------------TLE-----------
        // for (int i = 0; i < nums.length; i++) {
        // for (int j = i + 1; j < nums.length; j++) {
        // if ((j - i) != (nums[j] - nums[i]))
        // c++;
        // }
        // }

        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] - i;
        }

        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int prev = i;
            int freq = mp.getOrDefault(nums[i], 0);

            c += prev - freq;
            mp.put(nums[i], mp.getOrDefault(nums[i], 0) + 1);
        }
        return c;
    }
}