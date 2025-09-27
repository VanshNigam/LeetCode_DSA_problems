class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int i[] : flights) {
            adj.get(i[0]).add(new int[] { i[1], i[2] });
        }

        int dis[] = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { 0, src, 0 });//dis,node,k
        dis[src] = 0;

        while (q.size() > 0) {
            int x[] = q.poll();
            if (x[2] > k)
                continue;
            for (int i[] : adj.get(x[1])) {
                int wt = i[1] + x[0];
                int curr_k = 1 + x[2];
                int next = i[0];

                if (curr_k <= k + 1 && wt < dis[next]) {
                    q.add(new int[] { wt, next, curr_k });
                    dis[next] = wt;
                }
            }
        }

        return dis[dst] == Integer.MAX_VALUE ? -1 : dis[dst];
    }
}