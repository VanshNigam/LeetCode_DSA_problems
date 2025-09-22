class Solution {
    public int maxFrequencyElements(int[] nums) {
        int fr[] = new int[101];
        int c[] = new int[nums.length + 1];

        for (int i : nums) {
            fr[i]++;
        }
        for (int i : fr) {
            if (i != 0) {
                c[i] += i;
            }
        }
        for (int i = nums.length; i >= 0; i--) {
            if (c[i] > 0)
                return c[i];
        }
        return 0;
    }
}