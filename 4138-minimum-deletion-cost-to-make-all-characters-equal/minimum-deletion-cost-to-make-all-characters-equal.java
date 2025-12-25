class Solution {
    public long minCost(String s, int[] cost) {
        long[] m = new long[26];
        long max = 0, ans = 0;
        for (int i = 0; i < s.length(); ++i) {
            int c = s.charAt(i) - 'a';
            m[c] += cost[i];
            max = Math.max(m[c], max);
            ans += cost[i];
        }
        return ans - max;
    }
}