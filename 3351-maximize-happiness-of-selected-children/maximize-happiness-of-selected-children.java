import java.util.Arrays;

class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        int[] ar = happiness.clone();
        Arrays.sort(ar);
        for (int i = 0; i < ar.length / 2; i++) {
            int temp = ar[i];
            ar[i] = ar[ar.length - 1 - i];
            ar[ar.length - 1 - i] = temp;
        }

        long c = 0;
        int i = 0;
        int x = 0;
        while (k > 0) {
            k--;
            c += Math.max(ar[i] - x, 0);

            x++;
            i++;
        }
        return c;

    }
}