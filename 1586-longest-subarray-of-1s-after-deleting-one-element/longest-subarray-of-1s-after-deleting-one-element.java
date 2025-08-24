class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int zeroCount = 0; 

        int s = 0; 
        int ans = 0;

        for (int e = 0; e < n; e++) {
            if (nums[e] == 0) {
                zeroCount++;
            }
            while (zeroCount > 1) {
                if (nums[s] == 0) {
                    zeroCount--;
                }
                s++;
            }
            ans = Math.max(ans, e - s);
        }
        return ans;
    }
}
