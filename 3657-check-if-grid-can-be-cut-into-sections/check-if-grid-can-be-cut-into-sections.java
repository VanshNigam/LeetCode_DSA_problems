class Solution {
    public boolean merge(int[][] arr) {
        Arrays.sort(arr, (a, b) -> a[0] - b[0]);
        int prev[] = arr[0];
        ArrayList<int[]> a = new ArrayList<>();

        for (int i = 1; i < arr.length; i++) {
            int curr[] = arr[i];

            if (curr[0] < prev[1]) {
                prev[1] = Math.max(curr[1], prev[1]);
            } else {
                a.add(prev);
                prev = curr;
            }
        }
        a.add(prev);
        return (a.size()) >= 3;
    }

    public boolean checkValidCuts(int n, int[][] rec) {
        int hr[][] = new int[rec.length][2];
        int vr[][] = new int[rec.length][2];

        for (int i = 0; i < rec.length; i++) {
            hr[i][0] = rec[i][0]; 
            hr[i][1] = rec[i][2];

        }
        for (int i = 0; i < rec.length; i++) {
            vr[i][0] = rec[i][1];
            vr[i][1] = rec[i][3];
        }
        return merge(vr) || merge(hr);
    }
}