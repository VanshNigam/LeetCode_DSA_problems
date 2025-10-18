class Solution {

    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);

        int lastUsed = Integer.MIN_VALUE; // Track the last assigned value
        int distinctCount = 0; // Count of distinct elements

        for (int num : nums) {
            int minValue = Math.max(num - k, lastUsed + 1);
            if (minValue <= num + k) {
                distinctCount++;
                lastUsed = minValue; // Update the last used value
            }
        }

        return distinctCount;
    }
}