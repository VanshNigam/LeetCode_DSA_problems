class Solution {
    public int[][] merge(int[][] arr) {
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);

        int prev[] = arr[0];
        ArrayList<int[]> a = new ArrayList<>();

        for (int i = 1; i < arr.length; i++) {
            int curr[] = arr[i];

            if (curr[0] <= prev[1]) {
                prev[1] = Math.max(curr[1], prev[1]);
            } else {
                a.add(prev);
                prev = curr;
            }
        }
        a.add(prev);
        return a.toArray(new int[a.size()][]);
    }
}