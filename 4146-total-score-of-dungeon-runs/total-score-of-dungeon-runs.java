class Solution {
    public long totalScore(int hp, int[] damage, int[] req) {
        int n = damage.length;
        long[] S = new long[n+1];
        for(int i=1; i <=n; i++) S[i] = S[i-1] + damage[i-1];

        long ans = 0;
        for(int i=1; i <= n; i++) {
            long T = S[i] + req[i-1] - (long)hp;
            int k = lowerBound(S, T);
            if(k <= i-1) ans += (i-k);
        }
        return ans;
    }
    private int lowerBound(long[] a, long x) {
        int l=0, r = a.length - 1;
        while(l < r) {
            int m = (l + r) >>> 1;
            if(a[m] >= x) r = m;
            else l = m + 1;
        }
        return l;
    }
}