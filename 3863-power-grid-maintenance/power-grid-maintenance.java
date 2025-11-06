class Solution {
    int search(int x, int[] p) {
        return p[x] == x ? x : (p[x] = search(p[x], p));
    }

    void add(int x, int y, int[] p) {
        p[search(x, p)] = search(y, p);
    }

    public int[] processQueries(int c, int[][] con, int[][] queries) {
        int[] p = new int[c + 1];
        List<Integer> res = new ArrayList<>();
        boolean[] offline = new boolean[c + 1];

        for (int i = 1; i <= c; i++) p[i] = i;
        for (int[] e : con) add(e[0], e[1], p);

        Map<Integer, TreeSet<Integer>> mp = new HashMap<>();
        for (int i = 1; i <= c; i++) mp.computeIfAbsent(search(i, p), k -> new TreeSet<>()).add(i);

        for (int[] q : queries) {
            int x = q[1];
            int r = search(x, p);
            if (q[0] == 1) {
                res.add(!offline[x] ? x : (mp.get(r).isEmpty() ? -1 : mp.get(r).first()));
            } else {
                if (!offline[x]) {
                    offline[x] = true;
                    mp.get(r).remove(x);
                }
            }
        }

        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) ans[i] = res.get(i);
        return ans;
    }
}
