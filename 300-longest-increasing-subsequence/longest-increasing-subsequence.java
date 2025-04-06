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

//-------------------3rd solution
// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int next[]= new int[nums.length+1];
//         int curr[]= new int[nums.length+1];

//         int n = nums.length;
//         for (int i = n - 1; i >= 0; i--) {
//             for (int prev = i - 1; prev >= -1; prev--) {
//                 int len = 0 + next[prev + 1];

//                 if (prev == -1 || nums[i] > nums[prev])
//                     len = Math.max(len, 1 + next[i + 1]);

//                 curr[prev + 1] = len;

//             }
//             next=curr;
//         }
//         return next[-1 + 1];
//     }
// }

// -------------------4th solution
// class Solution {
//     public int lengthOfLIS(int[] nums) {
//         int n = nums.length;
//         int dp[] = new int[n];
//         Arrays.fill(dp, 1); //min LIS =1 for all
//         int ans = 1;

//         for (int i = 1; i < n; i++) {
//             for (int prev = 0; prev < i; prev++) {
//                 if (nums[prev] < nums[i]) {
//                     dp[i] = Math.max(dp[i], 1 + dp[prev]);
//                 }
//             }
//             ans = Math.max(ans, dp[i]);
//         }
//         return ans;
//     }
// }

//----------------------5th approach best-----------

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> arr = new ArrayList<>();

        arr.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > arr.get(arr.size() - 1)) {
                arr.add(nums[i]);
            } else {
                int l = 0;
                int r = arr.size();
                while (l < r) {
                    int mid = (l + r) / 2;
                    if (arr.get(mid) >= nums[i])
                        r = mid;
                    else
                        l = mid + 1;
                }
                arr.set(l, nums[i]);
            }
        }
        return arr.size();
    }
}
