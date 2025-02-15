import java.util.*;

class Solution {
    public double separateSquares(int[][] v) {
        List<int[]> v1 = new ArrayList<>();

        for (int[] sq : v) {
            int y1 = sq[1];
            int y2 = sq[1] + sq[2];
            v1.add(new int[] { y1, sq[2] });
            v1.add(new int[] { y2, -sq[2] });
        }

        Collections.sort(v1, (a, b) -> Integer.compare(a[0], b[0]));

        double total = 0, curr = 0, pv = 0;
        for (int[] point : v1) {
            int y = point[0];
            int width = point[1];
            total += curr * (y - pv);
            curr += width;
            pv = y;
        }

        double halfArea = total / 2.0;
        curr = 0;
        pv = 0;
        total = 0;

        for (int[] point : v1) {
            int y = point[0];
            int width = point[1];
            double nextArea = total + curr * (y - pv);
            if (nextArea >= halfArea) {
                return pv + (halfArea - total) / curr;
            }
            total = nextArea;
            curr += width;
            pv = y;
        }
        return pv;
    }
}
