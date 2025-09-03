class Solution {
    public boolean validPath(int n, int[][] e, int source, int destination) {
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

        for (int i = 0; i < n; i++)
            arr.add(new ArrayList<>());

        for (int i[] : e) {
            arr.get(i[0]).add(i[1]);
            arr.get(i[1]).add(i[0]);
        }

        boolean vis[] = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        vis[source] = true;

        while (!q.isEmpty()) {
            int pop = q.poll();
            if (pop == destination)
                return true;
            for (int neigh : arr.get(pop)) {
                if (!vis[neigh]) {
                    q.add(neigh);
                    vis[neigh] = true;
                }
            }
        }
        return false;
    }
}