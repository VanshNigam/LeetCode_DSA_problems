class Solution {
    int max;

    public int Dijkstra(ArrayList<ArrayList<int[]>> arr, int curr, int dis[]) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[] { 0, curr });
        boolean vis[] = new boolean[dis.length + 1];

        while (!pq.isEmpty()) {
            int[] pop = pq.poll();
            vis[pop[1]] = true;
            for (int neigh[] : arr.get(pop[1])) {
                if (!vis[neigh[0]] && pop[0] + neigh[1] <= max) {
                    pq.add(new int[] { pop[0] + neigh[1], neigh[0] });
                    dis[neigh[0]] = pop[0] + neigh[1];
                }
            }
        }
        int count = 0;
        for (int i : dis) {
            if (i <= max)
                count++;
        }

        return count;
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int INF = 100_000_000;
        int[][] dist = new int[n][n];
        
        // Initialize distances
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        
        // Set given edges
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            dist[u][v] = w;
            dist[v][u] = w;
        }
        
        // Floyd-Warshall
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        
        int minReach = n; // max possible
        int ans = -1;
        
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && dist[i][j] <= distanceThreshold) {
                    count++;
                }
            }
            
            if (count <= minReach) { // <= to pick largest city in tie
                minReach = count;
                ans = i;
            }
        }
        
        return ans;
    }
}