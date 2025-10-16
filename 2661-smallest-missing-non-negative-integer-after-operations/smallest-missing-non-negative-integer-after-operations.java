class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int[] freq = new int[value];

        for (int num : nums) {
            int mod = ((num % value) + value) % value; // ✅ normalize negative mods
            freq[mod]++;
        }

        int minCount = Integer.MAX_VALUE, ans = -1;
        for (int i = 0; i < value; i++) {
            if (freq[i] < minCount) {
                minCount = freq[i];
                ans = i;
            }
        }

        return ans + minCount * value; // \U0001f525 formula for smallest missing integer
    }
}
