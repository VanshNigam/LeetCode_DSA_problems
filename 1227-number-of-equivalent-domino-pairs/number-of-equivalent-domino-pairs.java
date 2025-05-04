class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] freq = new int[100];
        for (int[] d : dominoes) {
            if (d[0] > d[1])
                freq[d[0] * 10 + d[1]]++;
            else
                freq[d[1] * 10 + d[0]]++;
        }
        int count = 0;
        for (int f : freq) {
            count += (f - 1) * (f) / 2;
        }
        return count;
    }
}