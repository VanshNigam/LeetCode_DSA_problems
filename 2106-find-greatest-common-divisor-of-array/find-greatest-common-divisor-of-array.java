class Solution {
    public int findGCD(int[] nums) {
        int max = 0;
        int min = 10001;

        for (int i : nums) {
            max = Math.max(i, max);
            min = Math.min(i, min);
        }

        while (min != 0) {
            int tem = max % min;
            max = min;
            min = tem;
        }

        return max;
    }
}