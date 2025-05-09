class Solution {
    public int countPrimes(int n) {
        int c = 0;
        boolean prime[] = new boolean[n + 2];
        prime[0] = prime[1] = true;

        for (int i = 2; i < n; i = i + 1) {
            if (!prime[i]) {
                c++;
                for (int j = i * 2; j < n; j = j + i) {
                    prime[j] = true;
                }
            }
        }
        return c;
    }
}
