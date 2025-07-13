class Solution {
    public void dfs(int i, ArrayList<ArrayList<Integer>> adj, int vis[]) {
        vis[i] = 1;

        for (int neigh : adj.get(i)) {
            if (vis[neigh] == 0)
                dfs(neigh, adj, vis);
        }
    }

    public int findCircleNum(int[][] a) {
        int v = a.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < v; i++)
            adj.add(new ArrayList<>());
        // make adj list
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                if (a[i][j] == 1 && i != j) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        //make vis
        int vis[] = new int[v];
        int c = 0;
        for (int i = 0; i < v; i++) {
            if (vis[i] != 1) {
                c++;
                dfs(i, adj, vis);
            }
        }
        return c;
    }
}