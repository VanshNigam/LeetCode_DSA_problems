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
        max = distanceThreshold;
        ArrayList<ArrayList<int[]>> arr = new ArrayList<>();
        for (int i = 0; i < n; i++)
            arr.add(new ArrayList<>());

        for (int i[] : edges) {
            arr.get(i[0]).add(new int[] { i[1], i[2] });
            arr.get(i[1]).add(new int[] { i[0], i[2] });
        }
        int dis[];

        int fr[] = new int[n];
        for (int i = 0; i < n; i++) {
            dis = new int[n];
            Arrays.fill(dis, Integer.MAX_VALUE);

            fr[i] = Dijkstra(arr, i, dis);
            System.out.println(fr[i]);
        }

        int ans = -1, minReach = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (fr[i] <= minReach) { // <= ensures tie gives larger index
                minReach = fr[i];
                ans = i;
            }
        }
        return ans;

    }
}