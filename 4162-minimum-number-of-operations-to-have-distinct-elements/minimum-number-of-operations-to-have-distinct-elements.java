class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i : nums)
            mp.put(i, mp.getOrDefault(i, 0) + 1);

        int n = nums.length;
        int i = 0, c = 0;
        while (mp.size() != (n - i)) {
            int k = 0;
            while (i < n && k < 3) {
                if (mp.get(nums[i]) != 1)
                    mp.put(nums[i], mp.get(nums[i])-1);
                else
                    mp.remove(nums[i]);
                i++;
                k++;
            }
            c++;
            // System.out.println(mp);
        }
        return c;
    }
}