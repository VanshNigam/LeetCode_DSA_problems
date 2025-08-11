class Solution {
    public int[] productQueries(int n, int[][] q) {
        final int MOD = 1_000_000_007;
        
        // If n = 46 (101110₂), then
        //  pmul = [2, 4, 8, 32]---power of 2 at the place of 1 in binary
        // Collect powers of two present in n
        int[] pmul = new int[32]; // at most 32 bits
        int k = 0;
        int bit = 1;
        for (int pos = 0; pos < 31; pos++) {
            if ((n & (1 << pos)) != 0) {
                pmul[k++] = 1 << pos;
            }
        }

        int[] ans = new int[q.length];
        int idx = 0;
        for (int[] range : q) {
            long pro = 1;
            for (int j = range[0]; j <= range[1]; j++) {
                pro = (pro * pmul[j]) % MOD;
            }
            ans[idx++] = (int) pro;
        }
        return ans;
    }
}
