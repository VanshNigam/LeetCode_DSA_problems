class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int c = 0, cap = 0, sum = 0;
        int n = capacity.length;

        for (int i : apple)
            sum += i;
        for (int i = 0; i < n; i++) {
            cap += capacity[n - 1 - i];
            c++;
            if (cap >= sum)
                break;
        }
        return c;
    }
}