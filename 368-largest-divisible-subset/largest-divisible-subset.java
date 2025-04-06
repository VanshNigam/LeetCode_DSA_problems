class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int max = 0;
        int last = 0;

        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        int prevInd[] = new int[n];
        for (int i = 0; i < n; i++) {
            prevInd[i] = i;
            for (int pre = 0; pre < i; pre++) {
                if (nums[i] % nums[pre] == 0 && dp[i] < dp[pre] + 1) {
                    dp[i] = dp[pre] + 1;
                    prevInd[i] = pre;
                }
            }
            if (max < dp[i]) {
                max = dp[i];
                last = i;
            }
        }

        List<Integer> lst = new ArrayList<>();
        while (prevInd[last] != last) {
            lst.add(nums[last]);
            last = prevInd[last];
        }
        lst.add(nums[last]);
        return lst;
    }
}