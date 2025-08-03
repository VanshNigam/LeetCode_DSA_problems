class Solution {
    public int maxBalancedShipments(int[] nums) {
        int count = 0;
        int maxSoFar = Integer.MIN_VALUE;
        int n = nums.length;
        int start = 0;

        for (int i = 0; i < n; i++) {
            maxSoFar = Math.max(maxSoFar, nums[i]);
            // A valid balanced shipment must have at least 2 elements
            if (i > start && nums[i] < maxSoFar) {
                count++;
                start = i + 1;            // Start new shipment after this
                maxSoFar = Integer.MIN_VALUE;  // Reset max for new shipment
            }
        }

        return count;
    }
}