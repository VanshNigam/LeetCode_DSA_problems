class Solution {
    public int countPrimes(int n) {
        int c = 0;
        int prime[] = new int[n + 2];

        for (int i = 2; i < n; i = i + 1) {
            if (prime[i] == 0) {
                c++;
                for (int j = i * 2; j < n; j = j + i) {
                    prime[j] = 1;
                }
            }
        }
        return c;
    }
}
