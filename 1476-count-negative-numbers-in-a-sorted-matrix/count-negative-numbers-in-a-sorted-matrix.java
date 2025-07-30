class Solution {
    public int countNegatives(int[][] grid) {
        int c = 0;
        for (int i[] : grid) {
            int st = 0;
            int end = i.length - 1;

            while (st <= end) {
                int mid = (st + end) / 2;
                if (i[mid] < 0) {
                    end = mid - 1;
                } else
                    st = mid + 1;
            }
            c += i.length - end -1;
        }
        return c;
    }
}