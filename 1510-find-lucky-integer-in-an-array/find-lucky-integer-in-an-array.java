class Solution {
    public int findLucky(int[] arr) {
        int fr[] = new int[501];
        for (int i : arr)
            fr[i]++;
        for (int i = 500; i > 0; i--) {
            if (i == fr[i])
                return i;
        }
        return -1;
    }
}