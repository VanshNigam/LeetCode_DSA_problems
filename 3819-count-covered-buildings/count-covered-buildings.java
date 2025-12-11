class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        Map<Integer, TreeSet<Integer>> row = new HashMap<>();
        Map<Integer, TreeSet<Integer>> col = new HashMap<>();

        for (int b[] : buildings) {
            int x = b[0];
            int y = b[1];
            row.computeIfAbsent(x, k -> new TreeSet<>()).add(y);
            col.computeIfAbsent(y, k -> new TreeSet<>()).add(x);
        }

        int c = 0;

        for (int b[] : buildings) {
            int x = b[0];
            int y = b[1];

            boolean l = row.get(x).lower(y) != null;
            boolean r = row.get(x).higher(y) != null;
            boolean u = col.get(y).lower(x) != null;
            boolean d = col.get(y).higher(x) != null;

            if (l && r && u && d)
                c++;
        }
        return c;
    }
}