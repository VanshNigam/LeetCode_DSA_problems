class Solution {
    public int[][] merge(int[][] arr) {
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        ArrayList<int[]> l = new ArrayList<>();
        int prev[] = arr[0];
        for (int i[] : arr) {
            if (prev[1] >= i[0]) {
                prev[1] = Math.max(i[1], prev[1]);
            } else {
                l.add(prev);
                prev = i;
            }
        }
        l.add(prev);

        int ans[][] = new int[l.size()][2];
        int k = 0;
        for (int i[] : l) {
            ans[k] = i;
            k++;
        }
        return ans;
    }
}