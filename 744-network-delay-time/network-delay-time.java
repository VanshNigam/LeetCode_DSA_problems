class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());
        
        for (int[] t : times) {
            adj.get(t[0]).add(new int[]{t[1], t[2]}); // {node, time}
        }

        int[] dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); 
        pq.add(new int[]{0, k}); // {time, node}

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int time = cur[0], node = cur[1];
            
            if (time > dis[node]) continue;

            for (int[] nei : adj.get(node)) {
                int next = nei[0], wt = nei[1];
                if (time + wt < dis[next]) {
                    dis[next] = time + wt;
                    pq.add(new int[]{dis[next], next});
                }
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (dis[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, dis[i]);
        }
        return ans;
    }
}
