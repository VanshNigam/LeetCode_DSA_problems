class Solution {
    public int longestNiceSubarray(int[] nums) {
        int l = 0, r = 0, max = 0, bits = 0;

        while (r < nums.length) {
            // If adding nums[r] causes a bitwise conflict, shrink the window
            while ((bits & nums[r]) != 0) {
                bits ^= nums[l]; // Remove nums[l] from OR mask
                l++; // Shrink window from left
            }
            
            // Include nums[r] in the current window
            bits |= nums[r];
            max = Math.max(max, r - l + 1);
            r++; 
        }
        
        return max;
    }
}
