class Solution {
    public int countPrimes(int n) {
        int c = 0;
        boolean prime[] = new boolean[n + 2];
        Arrays.fill(prime,true);

        prime[0] = prime[1] = false;

        for (int i = 2; i < n; i++) {
            if (prime[i]) {
                c++;
                for (int j = i * 2; j < n; j += i) {
                    prime[j] = false;
                }
            }
        }
        return c;
    }
}
