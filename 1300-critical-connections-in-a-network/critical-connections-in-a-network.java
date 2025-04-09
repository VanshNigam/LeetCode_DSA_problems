class Solution {
    private int timer = 1;

    public void dfs(int node, int parent, int[] vis, ArrayList<ArrayList<Integer>> adj, int[] tin, int[] low,
            List<List<Integer>> ans) {
        vis[node] = 1;
        tin[node] = low[node] = timer;
        timer++;

        for (Integer it : adj.get(node)) {
            if (it == parent)
                continue;
            if (vis[it] == 0) {
                dfs(it, node, vis, adj, tin, low, ans);

                low[node] = Math.min(low[node], low[it]);
                if (low[it] > tin[node])
                    ans.add(Arrays.asList(it, node));
            } else {
                low[node] = Math.min(low[node], low[it]);
            }
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> conn) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        //adj is ready
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (List<Integer> i : conn) {
            adj.get(i.get(0)).add(i.get(1));
            adj.get(i.get(1)).add(i.get(0));
        }

        //............
        int vis[] = new int[n];
        int tin[] = new int[n];
        int low[] = new int[n];
        //ans list
        List<List<Integer>> ans = new ArrayList<>();
        dfs(0, -1, vis, adj, tin, low, ans);

        return ans;
    }
}