class Solution {
    private boolean chk(int k, int[] t, TreeMap<Integer,Integer> ws, int p, int s) {
        TreeMap<Integer,Integer> mp = new TreeMap<>(ws);
        int pills = p;
        for (int i = k - 1; i >= 0; --i) {
            int need = t[i];
            Integer hi = mp.lastKey();
            if (hi >= need) {
                dec(mp, hi);
            } else {
                if (pills == 0) return false;
                Integer lo = mp.ceilingKey(need - s);
                if (lo == null) return false;
                dec(mp, lo);
                pills--;
            }
        }
        return true;
    }

    private void dec(TreeMap<Integer,Integer> m, int k) {
        int c = m.get(k);
        if (c == 1) m.remove(k);
        else m.put(k, c - 1);
    }
    public int maxTaskAssign(int[] t, int[] w, int p, int s) {
        Arrays.sort(t);
        Arrays.sort(w);
        TreeMap<Integer,Integer> ws = new TreeMap<>();
        for (int x : w) ws.merge(x, 1, Integer::sum);
        int n = t.length, m = w.length;
        int lo = 0, hi = Math.min(n, m) + 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (chk(mid, t, ws, p, s)) lo = mid + 1;
            else hi = mid;
        }
        return lo - 1;
    }
}