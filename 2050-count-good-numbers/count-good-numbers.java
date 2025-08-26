class Solution {
//     \U0001f511
// prime digits {2, 3, 5, 7} (so 4 choices).
// even digits {0, 2, 4, 6, 8} (so 5 choices).
// Split positions // Even index count = (n+1)/2
                   // Odd index count = n/2

// Choices  // Even index → 5 choices
            // Odd index → 4 choices
            
// Answer = (5^evenIndex × 4^oddIndex) % MOD

    static final int MOD = 1000000007;

    public int countGoodNumbers(long n) {
        long evenPosition = (n + 1) / 2;
        long oddPosition = n / 2;
        long evenTrack = fast(5, evenPosition);
        long oddTrack = fast(4, oddPosition);
        return (int) ((evenTrack * oddTrack) % MOD);
    }

    long fast(long num, long power) {
        long ans = 1;
        num %= MOD;

        while (power > 0) {
            if (power % 2 == 1) {
                ans = (ans * num) % MOD;
            }
            num = (num * num) % MOD;
            power /= 2;
        }

        return ans;
    }

}