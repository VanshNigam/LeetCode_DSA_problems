class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        List<Integer> arr = new ArrayList<>();

        int st = 0;
        for (int i = 0; i < startTime.length; i++) {
            arr.add(startTime[i] - st);
            st = endTime[i];
        }
        arr.add(eventTime - st);
        // sliding window at window of k
        int cur = 0;
        for (int i = 0; i < k + 1; i++)
            cur += arr.get(i);
        int max = cur;
        for (int i = k + 1; i < arr.size(); i++) {
            cur += arr.get(i) - arr.get(i - (k + 1));
            max = Math.max(max, cur);
        }
        return max;
    }
}