class Solution {
    public int findFinalValue(int[] nums, int original) {
        Map<Integer, Boolean> mp = new HashMap<>();

        for (int i : nums)
            mp.put(i, true);

        int last = original;
        while (mp.containsKey(last)) {
            last *= 2;
        }
        return last;
    }
}