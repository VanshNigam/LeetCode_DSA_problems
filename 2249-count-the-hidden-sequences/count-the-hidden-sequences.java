class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long sum = upper;
        long min = 0;
        long max = 0;
        long psum = 0;

        for (int i = 0; i < differences.length; i++) {
            psum += differences[i];
            min = Math.min(min, psum);
            max = Math.max(max, psum);
        }
        return (int)(((upper - max) - (lower - min) + 1) < 0 ? 0 : ((upper - max) - (lower - min) + 1));
    }
}