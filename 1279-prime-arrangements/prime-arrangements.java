import java.math.BigInteger;


class Solution {
    public BigInteger fact(int x) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= x; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public int numPrimeArrangements(int n) {
        int[] prime = new int[n + 1];
        int mod = 1000000007;

        if (n <= 2) return 1;

        // Sieve of Eratosthenes to find primes
        Arrays.fill(prime, 1);
        prime[0] = 0;
        prime[1] = 2;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (prime[i] == 1) {
                for (int j = i * i; j <= n; j += i)
                    prime[j] = 0;
            }
        }

        int p = 0;
        int nonp = 0;
        for (int i = 1; i <= n; i++) {
            if (prime[i] == 1)
                p++;
            else
                nonp++;
        }

        BigInteger primeFactorial = fact(p);
        BigInteger nonPrimeFactorial = fact(nonp);

        BigInteger result = primeFactorial.multiply(nonPrimeFactorial).mod(BigInteger.valueOf(mod));
        
        return result.intValue(); 
    }
}
