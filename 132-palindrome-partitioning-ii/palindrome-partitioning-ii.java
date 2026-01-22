// class Solution {
//     static boolean isPalindrome(String s, int i, int j) {
//         while (i < j) {
//             if (s.charAt(i) != s.charAt(j))
//                 return false;
//             i++;
//             j--;
//         }
//         return true;
//     }

//     public int help(String s, int i, int dp[]) {
//         int n = s.length();
//         if (i == n)
//             return 0;
//         if (dp[i] != -1)
//             return dp[i];

//         int ans = Integer.MAX_VALUE;

//         for (int j = i + 1; j <= n; j++) {
//             int sum = Integer.MAX_VALUE;
//             if (isPalindrome(s, i, j - 1)) {
//                 ans = Math.min(ans, 1 + help(s, j, dp));
//             }
//         }
//         return dp[i] = ans;
//     }

//     public int minCut(String s) {
//         int dp[] = new int[s.length()];
//         Arrays.fill(dp, -1);
//         return help(s, 0, dp) - 1;
//     }
// }
class Solution {
    static boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public int minCut(String s) {
        int dp[] = new int[s.length() + 1];
        int n = s.length();

        // if (i == n)
        //     return 0;
        dp[n] = 0;

        // if (dp[i] != -1)
        //     return dp[i];

        for (int i = n - 1; i >= 0; i--) {

            int ans = Integer.MAX_VALUE;

            for (int j = i + 1; j <= n; j++) {
                int sum = Integer.MAX_VALUE;
                if (isPalindrome(s, i, j - 1)) {
                    ans = Math.min(ans, 1 + dp[j]);
                }
            }
            dp[i] = ans;
        }
        return dp[0] - 1;
    }
}