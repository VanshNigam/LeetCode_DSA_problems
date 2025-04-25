class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        Map<Long, Integer> mp = new HashMap<>();
        mp.put(0l, 1);
        long c = 0;
        long temp = 0;

        for (int i : nums) {
            temp += i % modulo == k ? 1 : 0;
            c += mp.getOrDefault((temp - k + modulo) % modulo, 0);
            mp.put(temp % modulo, mp.getOrDefault(temp % modulo, 0) + 1);
        }
        return c;
    }
}