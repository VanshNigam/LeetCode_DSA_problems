class Solution {
    static final int MOD = 1000000007;
    public int countGoodNumbers(long n) {
        long evenPosition = (n+1)/2;
        long oddPosition = n/2;
        long evenTrack = fast(5,evenPosition);
        long oddTrack = fast(4,oddPosition);
        return (int)((evenTrack * oddTrack) % MOD);
    }

    long fast(long num,long power){
        long ans = 1;
        num %= MOD;

        while(power >0){
            if(power % 2 ==1){
                ans = (ans *num) % MOD;
            }
        num = (num * num) % MOD;
        power /=2;
        }
        
        return ans;
    }
    
}