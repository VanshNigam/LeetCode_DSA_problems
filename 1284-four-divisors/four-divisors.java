class Solution {
    public int sumFourDivisors(int[] nums) {
        int ans = 0;
        for (int i : nums) {
            int m = (int)Math.sqrt(i);
            int c = 2;
            int sum = 1 + i;

            for (int j = 2; j <= m; j++) {
                if (i % j == 0) {
                    int sec = i / j;
                    c += sec == j ? 1 : 2;
                    sum += sec == j ? sec : (sec + j);
                }
            }
            if (c == 4)
                ans += sum;
        }
        return ans;
    }
}