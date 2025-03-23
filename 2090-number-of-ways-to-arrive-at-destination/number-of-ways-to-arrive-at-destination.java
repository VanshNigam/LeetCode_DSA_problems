class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int p[] : roads) {
            adj.get(p[0]).add(new int[] { p[1], p[2] });
            adj.get(p[1]).add(new int[] { p[0], p[2] });
        }
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        pq.offer(new long[] { 0, 0 });

        long dist[] = new long[n];
        int ways[] = new int[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;

        int mod = 1000_000_007;
        while (!pq.isEmpty()) {
            long curr[] = pq.poll();
            long d = curr[0];

            int node = (int) curr[1];
            if (d > dist[node])
                continue;

            for (int neigh[] : adj.get(node)) {
                int next = neigh[0];
                int time = neigh[1];

                if (dist[node] + time < dist[next]) {
                    dist[next] = dist[node] + time;
                    ways[next] = ways[node];

                    pq.offer(new long[]{dist[next], next});

                } else if (dist[node] + time == dist[next]) {
                    ways[next] = (ways[next] + ways[node]) % mod;
                }
            }
        }
        return ways[n - 1];
    }
}