import java.util.Arrays;

class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]); // Sort by start time
        int occupiedDays = 0, prevEnd = 0;

        for (int[] meeting : meetings) {
            int start = Math.max(meeting[0], prevEnd + 1); // Ensure no overlap count
            int end = meeting[1];

            if (start <= end) {
                occupiedDays += (end - start + 1);
                prevEnd = end;
            }
        }

        return days - occupiedDays;
    }
}