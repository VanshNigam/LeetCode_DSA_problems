class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        HashMap<Long, Long> map = new HashMap<>();
        int n = nums.length;
        long pre = 0;
        long best = Long.MIN_VALUE;
        for (int j = 0; j < n; j++) {
            long myC = j % k;
            if (!map.containsKey(myC))
                map.put(myC, pre);
            else
                map.put(myC, Math.min(map.get(myC), pre));
            pre += nums[j];
            long to_check = ((j % k) + 1 + k) % k;
            if (map.containsKey(to_check)) {
                best = Math.max(best, pre - map.get(to_check));
            }
        }
        return best;
    }
}