class Solution {
    public int countPrimes(int n) {
        int arr[] = new int[n];

        if (n <= 2)
            return 0;

        for (int i = 2; i < Math.sqrt(n) + 1; i++) {
            if (arr[i] == 0) {
                for (int j = i * i; j < n; j += i) {
                    arr[j] = 1;
                }
            }
        }
        int c = 0;
        for (int i = 2; i < n; i++)
            if (arr[i] == 0)
                c++;
        return c;
    }
}