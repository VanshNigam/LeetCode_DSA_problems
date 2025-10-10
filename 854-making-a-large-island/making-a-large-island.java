class DisjointSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    public int findParent(int n) {
        if (n == parent.get(n))
            return n;

        int GrandFather = findParent(parent.get(n));
        parent.set(n, GrandFather);

        return GrandFather;
    }

    public void unionBySize(int u, int v) {
        int father_u = findParent(u);
        int father_v = findParent(v);

        if (father_v == father_u)
            return;
        if (size.get(father_u) < size.get(father_v)) {
            parent.set(father_u, father_v);
            size.set(father_v, size.get(father_v) + size.get(father_u));
        } else {
            parent.set(father_v, father_u);
            size.set(father_u, size.get(father_u) + size.get(father_v));
        }
    }

}

class Solution {
    public int largestIsland(int[][] grid) {
        int[][] dir = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
        int rows = grid.length;
        int cols = grid[0].length;
        int vis[][] = new int[rows][cols];
        DisjointSet ds = new DisjointSet(rows * cols);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int r = i, c = j;
                    vis[r][c] = 1;
                    int node = r * cols + c;

                    for (int[] d : dir) {
                        int nr = r + d[0], nc = c + d[1];
                        if (nr >= 0 && nc >= 0 && nr < rows && nc < cols && vis[nr][nc] == 1) {
                            int adj = nr * cols + nc;
                            if (ds.findParent(node) != ds.findParent(adj)) {
                                ds.unionBySize(node, adj);
                            }
                        }
                    }
                }
            }
        }

        int maxArea = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    HashSet<Integer> set = new HashSet<>();
                    int area = 1;
                    for (int[] d : dir) {
                        int nr = i + d[0], nc = j + d[1];
                        if (nr >= 0 && nc >= 0 && nr < rows && nc < cols && grid[nr][nc] == 1) {
                            set.add(ds.findParent(nr * cols + nc));
                        }
                    }
                    for (int parentNode : set) {
                        area += ds.size.get(parentNode);
                    }
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        for (int i = 0; i < rows * cols; i++) {
            maxArea = Math.max(maxArea, ds.size.get(ds.findParent(i)));
        }
        return maxArea;
    }
}