
class Solution {
    public long minMoves(int[] balance) {
        long sum = 0;
        int index = -1;
        int n = balance.length;
        for (int i = 0; i < balance.length; i++) {
            sum += balance[i];
            if (balance[i] < 0) {
                index = i;
            }
        }
        if (sum < 0) {
            return -1;
        }

        if (index == -1) {
            return 0;
        }

        long result = 0;
        int mul = 1;
        while (balance[index] < 0) {
            int currVal = balance[(index + mul + n) % n] + balance[(index - mul + n) % n];
            int min = Math.min(currVal, -balance[index]);
            balance[index] += min;
            result += (long) min * mul;
            mul++;
        }
        return result;
    }
}