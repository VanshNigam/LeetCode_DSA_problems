class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();

        int x = 0;
        int y = 0;
        int sum = 0;
        int max = 0;

        while (y < nums.length) {
            mp.put(nums[y], mp.getOrDefault(nums[y], 0) + 1);
            sum += nums[y];

            // Shrink the window if duplicates are found
            while (mp.get(nums[y]) > 1) {
                int pop = nums[x];
                sum -= pop;
                if (mp.get(pop) == 1) {
                    mp.remove(pop);
                } else {
                    mp.put(pop, mp.get(pop) - 1);
                }
                x++;
            }

            max = Math.max(max, sum);
            y++;
        }

        return max;
    }
}
