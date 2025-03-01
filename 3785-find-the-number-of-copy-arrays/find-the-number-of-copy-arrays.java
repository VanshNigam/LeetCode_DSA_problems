class Solution {
    public int countArrays(int[] original, int[][] bounds) {
        int left = bounds[0][0];
        int right = bounds[0][1];

        for (int i = 1; i < original.length; i++) {
            int diff = original[i] - original[i - 1];

            left = Math.max(left + diff, bounds[i][0]);
            right = Math.min(right + diff, bounds[i][1]);

            if (left > right)   return 0;
        }
        return right - left + 1;
    }
}