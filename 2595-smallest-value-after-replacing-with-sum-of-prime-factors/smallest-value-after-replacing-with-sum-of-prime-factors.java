class Solution {
    public boolean isPrime(int n){
        if(n == 2) return true;
        for(int i=2;i<Math.sqrt(n)+1;i++)
            if(n%i==0)return false;
        return true;
    }
    public int getFirst(int n){
        if(isPrime(n))return n;
        for(int i=2;i<n;i++)
            if(n%i==0)return i;
        return n;
    } 
    public int getSum(int n){
        int sum=0;
        while(!isPrime(n)){
            int x=getFirst(n);
            n=n/x;
            sum+=x;
        }
        sum+=n;
        return sum;
    }
    public int smallestValue(int n) {
        if(isPrime(n))return n;
        int sum=getSum(n);
        if(sum==n)return n;
        return smallestValue(sum);
    }
}