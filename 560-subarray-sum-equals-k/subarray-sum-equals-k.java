class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        int n = nums.length, sum = 0, c = 0;
        mp.put(0, 1);

        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (mp.containsKey(sum - k))
                c += mp.get(sum - k);
            mp.put(sum, mp.getOrDefault(sum, 0) + 1);
        }
        return c;
    }
}