class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int l = grid.length;
        long n = l * l;

        long sum = (n * (n + 1)) / 2;
        long squareSum = (n * (n + 1) * (2 * n + 1)) / 6;

        long s = 0;
        long psum = 0;
        for (int a[] : grid) {
            for (int i : a) {
                s += i;
                psum += ((long)i * i);
            }
        }

        long diff1 = sum - s; // remain b-a
        long diff2 = squareSum - psum; // remain b^2-a^2

        long ratio = diff2 / diff1; // a+b
        return new int[] { (int)(ratio - diff1) / 2, (int)(ratio + diff1) / 2 };
    }
}