// class Solution {
//     public int help(int[] nums, int dp[][], int i, int prev) {
//         if (i == nums.length)
//             return 0;
//         if (dp[i][prev + 1] != -1)
//             return dp[i][prev + 1];

//         int take = 0;
//         int nottake = 0;
//         if (prev == -1 || nums[i] > nums[prev]) {
//             take = help(nums, dp, i + 1, i) + 1;
//         }
//         nottake = help(nums, dp, i + 1, prev);

//         return dp[i][prev + 1] = Math.max(take, nottake);
//     }

//     public int lengthOfLIS(int[] nums) {
//         int dp[][] = new int[nums.length][nums.length];
//         for (int i[] : dp)
//             Arrays.fill(i, -1);
//         return help(nums, dp, 0, -1);
//     }
// }

//2nd solution

// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int dp[][] = new int[nums.length+1][nums.length + 1];

//         int n = nums.length;
//         for (int i = n - 1; i >= 0; i--) {
//             for (int prev = i - 1; prev >= -1; prev--) {
//                 int len = 0 + dp[i + 1][prev + 1];

//                 if (prev == -1 || nums[i] > nums[prev])
//                     len = Math.max(len, 1 + dp[i + 1][i + 1]);

//                 dp[i][prev + 1] = len;

//             }
//         }
//         return dp[0][-1 + 1];
//     }
// }

class Solution {
    public int lengthOfLIS(int[] nums) {
        int next[]= new int[nums.length+1];
        int curr[]= new int[nums.length+1];

        int n = nums.length;
        for (int i = n - 1; i >= 0; i--) {
            for (int prev = i - 1; prev >= -1; prev--) {
                int len = 0 + next[prev + 1];

                if (prev == -1 || nums[i] > nums[prev])
                    len = Math.max(len, 1 + next[i + 1]);

                curr[prev + 1] = len;

            }
            next=curr;
        }
        return next[-1 + 1];
    }
}