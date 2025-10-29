class Solution {
    public int smallestNumber(int n) {
        double val = 0;
        int i = 0;
        while (val < n) {
            val = (Math.pow(2, i)) - 1;
            i++;
        }
        return (int) val;
    }
}