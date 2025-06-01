class Solution {
    public long distributeCandies(int n, int limit) {
        long ways = 0;

        //child1
        int minCh1 = Math.max(0, n - 2 * limit);
        int maxCh1 = Math.min(n, limit);

        for (int i = minCh1; i <= maxCh1; i++) {
            int N = n - i;//remain candy for ch2,ch3

            //now distribute the candy between ch2,ch3
            int minCh2 = Math.max(0, N - limit);
            int maxCh2 = Math.min(N, limit);

            ways += (maxCh2 - minCh2 + 1);
        }
        return ways;
    }
}