class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < graph.length; i++) {
            adj.add(new ArrayList<>());
        }
        int indeg[] = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            for (int x : graph[i]) { // use original graph
                adj.get(x).add(i); // reverse edge
                indeg[i]++; // increase indegree
            }
        }

        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        // use topo sort and get the safe node
        //safe node == all path end on terminal || safenode
        //indeg==0 is safe node 
        for (int i = 0; i < graph.length; i++) {
            if (indeg[i] == 0)
                q.add(i);
        }
        while (!q.isEmpty()) {
            int pop = q.poll();
            ans.add(pop);
            for (int neigh : adj.get(pop)) {
                indeg[neigh]--;
                if (indeg[neigh] == 0)
                    q.add(neigh);
            }
        }
        Collections.sort(ans); // \U0001f511 ensure ascending order
        return ans;
    }
}