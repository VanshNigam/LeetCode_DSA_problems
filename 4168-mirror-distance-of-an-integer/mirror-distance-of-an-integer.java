class Solution {
    public int help(int n) {
        int rev = 0;
        while (n > 0) {
            rev = rev * 10 + n % 10;
            n /= 10;
        }
        return rev;
    }

    public int mirrorDistance(int n) {
        int rev = help(n);

        return Math.abs(rev - n);
    }
}