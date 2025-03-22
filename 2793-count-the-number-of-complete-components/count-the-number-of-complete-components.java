class Solution {
    static int e=0,v=0;
    public void dfs(int i, List<List<Integer>> adj, Set<Integer> vis) {
            vis.add(i);
            v++;
            for(int neigh:adj.get(i)){
                e++;
                if(!vis.contains(neigh))dfs(neigh, adj, vis);
            }
    }

    public int countCompleteComponents(int n, int[][] edges) {
        // Make adjancy list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int a[] : edges) {
            List<Integer> l = adj.get(a[0]);
            List<Integer> l2 = adj.get(a[1]);
            l.add(a[1]);
            l2.add(a[0]);
        }
        Set<Integer> vis = new HashSet<>();
        int c = 0;
        for (int i = 0; i < n; i++) {
            if (!vis.contains(i)) {
                dfs(i, adj, vis);
                if(v*(v-1)==e)c++;
            }
            v=0;e=0;
        }
        return c;
    }
}