class Solution {
    public int[] findOrder(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i[] : edges) {
            adj.get(i[0]).add(i[1]);
        }
        // ----------------------------------------------//
        int indegree[] = new int[V];
        for (int i = 0; i < V; i++) {
            for (int neigh : adj.get(i)) {
                indegree[neigh]++;
            }
        }
        //using----- BFS---Queue----------------
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }
        //Bfs
        int[] ans = new int[V];
        int k = V-1;
        while (!q.isEmpty()) {
            int pop = q.poll();
            ans[k--] = pop;
            for (int neigh : adj.get(pop)) {
                indegree[neigh]--;
                if (indegree[neigh] == 0)
                    q.add(neigh);
            }
        }
        // After BFS loop
        if (k == -1)
            return ans;
        return new int[0]; // cycle detected, no topo order possible
    }
}