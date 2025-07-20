class Solution {
    public int maxSumDistinctTriplet(int[] x, int[] y) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int i = 0; i < x.length; i++) {
            pq.add(new int[] { y[i], i });
        }
        Map<Integer, Boolean> mp2 = new HashMap<>();
        int ans = 0;

        while (!pq.isEmpty() && mp2.size() < 3) {
            int i[] = pq.poll();
            int pop = i[0];
            int ind = i[1];

            if (!mp2.containsKey(x[ind])) {
                mp2.put(x[ind], true);
                ans += pop;
            }
            // System.out.println(mp);
            // System.out.println(mp2);
        }
        if (mp2.size() != 3)return -1;
        return ans;
    }
}