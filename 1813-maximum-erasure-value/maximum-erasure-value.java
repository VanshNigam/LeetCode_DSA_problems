class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();

        int x = 0;
        int y = 0;
        int max = 0;
        int sum = 0;

        while (y < nums.length) {
            mp.put(nums[y], mp.getOrDefault(nums[y], 0) + 1);
            sum += nums[y];

            while (mp.get(nums[y]) > 1) {
                int pop = nums[x];
                sum -= pop;
                if (mp.containsKey(pop) && mp.get(pop) > 1)
                    mp.put(pop, mp.get(pop) - 1);
                else
                    mp.remove(pop);
                x++;
            }
            max = Math.max(max, sum);
            y++;
        }
        return max;
    }
}